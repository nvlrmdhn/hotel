package com.kelompok1.transaksi.transaksiService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kelompok1.transaksi.entity.Kamar;
import com.kelompok1.transaksi.entity.Member;
import com.kelompok1.transaksi.entity.Payment;
import com.kelompok1.transaksi.entity.Transaksi;
import com.kelompok1.transaksi.factory.TransaksiFactory;
import com.kelompok1.transaksi.factory.impl.PembayaranFactory;
import com.kelompok1.transaksi.observer.TransaksiObserver;
import com.kelompok1.transaksi.observer.impl.TransaksiSubject;
import com.kelompok1.transaksi.repository.TransaksiRepository;
import com.kelompok1.transaksi.transaksiService.TransaksiService;

@Service
public class TransaksiServiceImpl implements TransaksiService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    TransaksiRepository transaksiRepository;
    
     @Autowired
    private TransaksiSubject transaksiSubject;

    @Override
    public Transaksi booking(Transaksi transaksi){
        Transaksi transaksiResp = new Transaksi();

        String urlMember = "http://localhost:8080/member/profile?id=" + transaksi.getMemberId();
        Member member = restTemplate.getForObject(urlMember, Member.class);

        if (member == null) {
            return transaksiResp;   
        }

        String urlKamar = "http://localhost:8081/kamar/search?id=" + transaksi.getKamarId();
        Kamar kamar = restTemplate.getForObject(urlKamar, Kamar.class);

        if (kamar == null || !kamar.getStatus().equals("empty")) {
            return transaksiResp;   
        }

        int result = transaksiRepository.insertBooking(transaksi);
        if (result > 0) {
            String urlUpdate = "http://localhost:8081/kamar/update?status=onbook&id=" + transaksi.getKamarId();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(null, headers);
            ResponseEntity<Kamar> resultUpdate = restTemplate.exchange(urlUpdate, HttpMethod.POST,entity,Kamar.class);

            Transaksi newTransaksi = transaksiRepository.getNewTransaksi(transaksi.getMemberId(), transaksi.getKamarId());
            transaksiResp = newTransaksi;
        }

        return transaksiResp;
    }

    @Override
    public Payment payment(Double amount, String paymentType){
        Payment payment = new Payment();

        TransaksiFactory transaksiFactory = PembayaranFactory.getTransaksi(paymentType);
        payment = transaksiFactory.prosesPembayaran(amount);
        transaksiSubject.notifyObservers(payment);
        

        return payment;
     }
}

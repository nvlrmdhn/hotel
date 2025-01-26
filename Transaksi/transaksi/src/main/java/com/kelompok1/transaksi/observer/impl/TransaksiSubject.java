package com.kelompok1.transaksi.observer.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kelompok1.transaksi.entity.Payment;
import com.kelompok1.transaksi.observer.TransaksiObserver;

@Component
public class TransaksiSubject {
      private final List<TransaksiObserver> observers = new ArrayList<>();

    @Autowired
    public TransaksiSubject(List<TransaksiObserver> observers) {
        this.observers.addAll(observers);
    }

    public void registerObserver(TransaksiObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TransaksiObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Payment payment) {
        for (TransaksiObserver observer : observers) {
            observer.update(payment);
        }
    }
}

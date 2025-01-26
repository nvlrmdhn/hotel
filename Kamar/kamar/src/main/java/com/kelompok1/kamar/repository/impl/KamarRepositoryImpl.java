package com.kelompok1.kamar.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.kelompok1.kamar.entity.Kamar;
import com.kelompok1.kamar.repository.KamarRepository;

@Repository
public class KamarRepositoryImpl implements KamarRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Kamar getKamar(Integer id, String nama, Double harga, String status, Integer nomorKamar) {
    StringBuilder sql = new StringBuilder("SELECT * FROM kamar WHERE 1=1");

    List<Object> params = new ArrayList<>();

    if (id != null) {
        sql.append(" AND id = ?");
        params.add(id);
    }
    if (nama != null && !nama.isEmpty()) {
        sql.append(" AND LOWER(nama) LIKE LOWER(?)");
        params.add("%" + nama + "%");
    }
    if (harga != null) {
        sql.append(" AND harga <= ?");
        params.add(harga);
    }
    if (status != null && !status.isEmpty()) {
        sql.append(" AND LOWER(status) LIKE LOWER(?)");
        params.add("%" + status + "%"); 
    }
    if (nomorKamar != null) {
        sql.append(" AND no_kamar = ?");
        params.add(nomorKamar);
    }

    Object[] paramArray = params.toArray(new Object[0]);
    try {
        return jdbcTemplate.queryForObject(sql.toString(), paramArray, (rs, rowNum) -> {
            Kamar kamar = new Kamar();
            kamar.setId(rs.getInt("id"));
            kamar.setNama(rs.getString("nama"));
            kamar.setHarga(rs.getDouble("harga"));
            kamar.setStatus(rs.getString("status"));
            kamar.setNoKamar(rs.getInt("no_kamar"));
            return kamar;
        });
    } catch (EmptyResultDataAccessException e) {
        return null;
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error retrieving kamar data: " + e.getMessage());
    }
}

    @Override
    public List<Kamar> getAllKamar(String nama, Double harga, String status, Integer nomorKamar) {
        StringBuilder sql = new StringBuilder("SELECT * FROM kamar WHERE 1=1");
    
        List<Object> params = new ArrayList<>();
    
        if (nama != null && !nama.isEmpty()) {
            sql.append(" AND LOWER(nama) LIKE LOWER(?)");
            params.add("%" + nama + "%");
        }
        if (harga != null) {
            sql.append(" AND harga <= ?");
            params.add(harga);
        }
        if (status != null && !status.isEmpty()) {
            sql.append(" AND LOWER(status) LIKE LOWER(?)");
            params.add("%" + status + "%"); 
        }
        if (nomorKamar != null) {
            sql.append(" AND no_kamar = ?");
            params.add(nomorKamar);
        }
    
        Object[] paramArray = params.toArray(new Object[0]);
    
        try {
            return jdbcTemplate.query(sql.toString(), paramArray, (rs, rowNum) -> {
                Kamar kamar = new Kamar();
                kamar.setId(rs.getInt("id"));
                kamar.setNama(rs.getString("nama"));
                kamar.setHarga(rs.getDouble("harga"));
                kamar.setStatus(rs.getString("status"));
                kamar.setNoKamar(rs.getInt("no_kamar"));
                return kamar;
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving kamar data: " + e.getMessage());
        }
    }

@Override
public int updateKamar(Integer id, String nama, Double harga, String status) {
    StringBuilder sql = new StringBuilder("UPDATE kamar SET ");

    List<Object> params = new ArrayList<>();

    if (nama != null && !nama.isEmpty()) {
        sql.append("nama = ?, ");
        params.add(nama);
    }
    if (harga != null) {
        sql.append("harga = ?, ");
        params.add(harga);
    }
    if (status != null && !status.isEmpty()) {
        sql.append("status = ?, ");
        params.add(status);
    }

    if (params.size() > 0) {
        sql.setLength(sql.length() - 2);
        sql.append(" WHERE id = ?");
        params.add(id);
    } else {
        throw new IllegalArgumentException("No parameters provided to update.");
    }

    try {
        return jdbcTemplate.update(sql.toString(), params.toArray());
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error updating kamar data: " + e.getMessage());
    }
}
}

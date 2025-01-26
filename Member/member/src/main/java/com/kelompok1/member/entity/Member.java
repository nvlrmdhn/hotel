package com.kelompok1.member.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Member {

    private int memberId;
    private String nama;
    private String email;
    private int noHandphone;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNoHandphone() {
        return noHandphone;
    }

    public void setNoHandphone(int noHandphone) {
        this.noHandphone = noHandphone;
    }
}

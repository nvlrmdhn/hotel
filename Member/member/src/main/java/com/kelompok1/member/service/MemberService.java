package com.kelompok1.member.service;

import java.util.List;

import com.kelompok1.member.entity.Member;


public interface MemberService {

    Member memberRegister(Member member);

    Member getMember(int id);

    List<Member> getMemberAll();

}

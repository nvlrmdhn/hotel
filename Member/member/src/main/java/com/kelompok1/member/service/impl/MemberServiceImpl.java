package com.kelompok1.member.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelompok1.member.entity.Member;
import com.kelompok1.member.repository.MemberRepository;
import com.kelompok1.member.service.MemberService;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member memberRegister(Member member){
        Member respMember = new Member();
        int result = memberRepository.insertMember(member);
        if (result > 0) {
            respMember = member;
        }

        return respMember;
    }

    @Override
    public Member getMember(int id){
        Member member = new Member();
        member = memberRepository.getMembers(id);
        return member;
    }

    @Override
    public List<Member> getMemberAll(){
        List<Member> member = new ArrayList<>();
        member = memberRepository.getAllMembers();

        return member;
    }
    
}

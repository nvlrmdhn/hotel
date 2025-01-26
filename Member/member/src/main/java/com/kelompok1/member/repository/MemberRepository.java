package com.kelompok1.member.repository;

import java.util.List;

import com.kelompok1.member.entity.Member;

public interface MemberRepository {

    int insertMember(Member member);

    Member getMembers(int id);

    List<Member> getAllMembers();
    
}

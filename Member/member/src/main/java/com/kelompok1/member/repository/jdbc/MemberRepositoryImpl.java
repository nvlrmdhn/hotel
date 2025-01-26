package com.kelompok1.member.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kelompok1.member.entity.Member;
import com.kelompok1.member.repository.MemberRepository;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertMember(Member member) {
        String sql = "INSERT INTO member (nama, email, no_handphone) VALUES (?, ?, ?)";
    
        return jdbcTemplate.update(sql, member.getNama(), member.getEmail(), member.getNoHandphone());
    }

    @Override
    public Member getMembers(int id) {
        String sql = "SELECT id, nama, email, no_handphone FROM member WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Member member = new Member();
            member.setMemberId(rs.getInt("id"));
            member.setNama(rs.getString("nama"));
            member.setEmail(rs.getString("email"));
            member.setNoHandphone(rs.getInt("no_handphone"));
            return member;
        }, id);
    }

    @Override
    public List<Member> getAllMembers() {
        String sql = "SELECT id, nama, email, no_handphone FROM member";
    return jdbcTemplate.query(sql, (rs, rowNum) -> {
        Member member = new Member();
        member.setMemberId(rs.getInt("id"));
        member.setNama(rs.getString("nama"));
        member.setEmail(rs.getString("email"));
        member.setNoHandphone(rs.getInt("no_handphone"));
        return member;
        });
    }
}

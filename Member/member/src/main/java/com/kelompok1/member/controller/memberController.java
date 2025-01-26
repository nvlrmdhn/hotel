package com.kelompok1.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kelompok1.member.entity.Member;
import com.kelompok1.member.service.MemberService;
import com.kelompok1.member.Logger;


@RestController
@RequestMapping("member")
public class memberController {

    private final Logger logger = Logger.getInstance();

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Object> memberRegister(@RequestBody Member member){
        logger.info("Register " + member.getEmail());
        
        Member resMember = memberService.memberRegister(member);
        if(resMember != null){
            return new ResponseEntity<Object>(resMember, HttpStatus.OK);
        } else{
            return new ResponseEntity<Object>(resMember, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<Object> memberProfile(@RequestParam("id") int id){
        logger.info("get profile");

        Member member = memberService.getMember(id);

        return new ResponseEntity<Object>(member, HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Object> memberAll(){
        logger.info("get all");

        List<Member> member = memberService.getMemberAll();

        return new ResponseEntity<Object>(member, HttpStatus.OK);
    }
}

package com.fullstack.safeheaven.controller;

import com.fullstack.safeheaven.Repository.MembersRepository;
import com.fullstack.safeheaven.entity.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")
public class MembersController {

    @Autowired
    private MembersRepository membersRepository;

    @PostMapping("/member")
    Members newMember(@RequestBody Members newMember){
        return membersRepository.save(newMember);
    }
    @GetMapping("/members")
    List<Members> getAllMembers(){
        return membersRepository.findAll();
    }



}

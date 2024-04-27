package com.fullstack.safeheaven.controller;

import com.fullstack.safeheaven.Repository.LostChildrenRepository;
import com.fullstack.safeheaven.entity.LostChildren;
import com.fullstack.safeheaven.exception.userNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class LostChildrenController {

    @Autowired
    private LostChildrenRepository lostChildrenRepository;

    @PostMapping("/children")
    LostChildren newChild(@RequestBody LostChildren newChild){
        return lostChildrenRepository.save(newChild);
    }
    @GetMapping("/children")
    List<LostChildren> getAllChildren(){

        return lostChildrenRepository.findAll();
    }

    @Autowired
    public LostChildrenController(LostChildrenRepository lostChildrenRepository) {
        this.lostChildrenRepository = lostChildrenRepository;
    }


    @GetMapping("/children/{name}")
    public List<LostChildren> getChildrenByName(@PathVariable String name) {
        return lostChildrenRepository.findByName(name);
    }

    // In LostChildrenController.java

//    @PutMapping("/children/{id}")
//    public LostChildren updateChild(@PathVariable int id, @RequestBody LostChildren childDetails) {
//        LostChildren child = lostChildrenRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Child not found with id " + id));
//
//        // Update fields
//        child.setName(childDetails.getName());
//        child.setAge(childDetails.getAge());
//        child.setGender(childDetails.getGender());
//        child.setLocation(childDetails.getLocation());
//        // Continue for all fields you wish to update
//
//        return lostChildrenRepository.save(child);
//    }
@PutMapping("/children/{id}")
public LostChildren updateChild(@PathVariable int id, @RequestBody LostChildren childDetails) {
    try {
        LostChildren child = lostChildrenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Child not found with id " + id));

        // Update fields
        child.setName(childDetails.getName());
        child.setAge(childDetails.getAge());
        child.setGender(childDetails.getGender());
        child.setLocation(childDetails.getLocation());
        child.setFoundBy(childDetails.getFoundBy());
        child.setHisPhoneNumber(childDetails.getHisPhoneNumber());
        child.setStatus(childDetails.getStatus());
        // Add more setters for other fields if needed

        return lostChildrenRepository.save(child);
    } catch (Exception e) {
        // Handle any errors, e.g., child not found or database error
        throw new RuntimeException("Failed to update child with id " + id, e);
    }
}


    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable int id){
        lostChildrenRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
}






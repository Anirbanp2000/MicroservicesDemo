package com.micro.demo.MicroServicesDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.micro.demo.MicroServicesDemo.entity.User;
import com.micro.demo.MicroServicesDemo.service.userService;




@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService user;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId)
    {
        
                User user=this.user.getUser(userId);
                
                //http://localhost:8087/user/1 (calling)
                List contact = this.restTemplate.getForObject("http://contact-service/contact/user/"+userId,List.class);
                user.setContact(contact);
                
                return user;
    }
}

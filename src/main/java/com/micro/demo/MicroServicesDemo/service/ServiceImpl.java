package com.micro.demo.MicroServicesDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.demo.MicroServicesDemo.entity.User;

@Service
public class ServiceImpl implements userService{

	//fake list
    List<User> list= List.of(
            new User(1l,"Anirban","6743644577"),
            new User(2l,"Nikita","4534764577"),
            new User(3l,"Dipankar","5745573667"),
            new User(4l,"Dolly","5344635537"),
            new User(5l,"Akash","9783663883")
            );
            
    @Override
    public User getUser(Long id) {
      
        return (list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null));
    }

}


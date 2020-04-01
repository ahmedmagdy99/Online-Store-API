package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository users;

    public List<User> listall(){

        return users.findAll();
    }

    public void save(User user)
    {
        users.save(user);
    }
}

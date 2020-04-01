package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> list()
    {
        return service.listall();
    }

    @PostMapping("/register")
    public void register(@RequestBody User user)
    {
        service.save(user);
    }
}

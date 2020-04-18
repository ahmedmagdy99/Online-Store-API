package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String home(){
        return ("You are logged in Successfully");
    }

    @GetMapping("/users")
    public List<User> list()
    {
        return service.listall();
    }

    @PostMapping("/register")
    public void register(@Valid @RequestBody User user)
    {
        service.save(user);
    }
}

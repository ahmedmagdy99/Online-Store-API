package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository users;

    public List<User> listall(){

        return users.findAll();
    }

    public String save(User user)
    {
        Optional<User> storedUser = users.findByEmail(user.getEmail());
        if(storedUser.isPresent())
        {
            return ("This Email is used before please use other Email");
        }
        else {
            if(user.getRoles().equals("ROLE_USER")||user.getRoles().equals("ROLE_ADMIN"))
            {
                users.save(user);
                return ("Your account has been registered successfully");
            }
            else
            {
                return ("Your account has a rong role");
            }
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = users.findByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("The Email (" + email + ") is not found"));
        return user.map(UserPrincipal::new).get();
    }
}

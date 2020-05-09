package com.example.lab10;


import com.example.lab10.entity.ApplicationUser;
import com.example.lab10.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Lab10Application {

    @Autowired
    private ApplicationUserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @PostConstruct
    public void addUser(){
        if(userRepository.findByUsername("bilal")==null){
            String pas=passwordEncoder.encode("bilal");
            ApplicationUser user=new ApplicationUser(1,"bilal","");
            userRepository.save(user);
        }
    }
    public static void main(String[] args) {
        SpringApplication.run(Lab10OneToManyMapppingApplication.class, args);
    }

}

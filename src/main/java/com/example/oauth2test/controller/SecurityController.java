package com.example.oauth2test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/admin")
    public String admin(){
        return "i am admin";
    }

    @GetMapping("/admin/hello")
    public String helloAdmin() {
        return "hello admin";
    }

    @GetMapping("/user")
    public String user() {
        return "i am a user";
    }

    @GetMapping("/dba")
    public String dba() {
        return "i am dba";
    }


}

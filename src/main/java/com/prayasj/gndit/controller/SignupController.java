package com.prayasj.gndit.controller;

import com.prayasj.gndit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Controller
public class SignupController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/signup-page")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public void signupCredentials(@RequestBody User user) {
        RequestEntity<User> signupRequest = RequestEntity
                .post(URI.create("https://kisan-grain-seller.herokuapp.com/api/signup"))
                .accept(MediaType.APPLICATION_JSON)
                .body(user);
        ResponseEntity<Void> signupResponse = restTemplate.exchange(signupRequest, Void.class);
        System.out.print(signupResponse.getStatusCode());
    }
}

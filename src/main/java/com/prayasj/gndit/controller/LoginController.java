package com.prayasj.gndit.controller;

import com.prayasj.gndit.model.User;
import com.prayasj.gndit.response.LoginErrorResponse;
import com.prayasj.gndit.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Controller
public class LoginController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<? extends LoginResponse> loginCredentials(@RequestBody User user) {
        RequestEntity<User> loginRequest = RequestEntity
                .post(URI.create("https://kisan-grain-seller.herokuapp.com/api/login"))
                .accept(MediaType.APPLICATION_JSON)
                .body(user);

        try {
            ResponseEntity<LoginResponse> loginResponse =
                    restTemplate.exchange(loginRequest, LoginResponse.class);
            String jwt_token = loginResponse.getHeaders().getFirst("Jwt_token");
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Jwt_token", jwt_token);
            return new ResponseEntity<>(loginResponse.getBody(), httpHeaders, HttpStatus.OK);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.UNAUTHORIZED){
                LoginErrorResponse loginErrorResponse = new LoginErrorResponse();
                return new ResponseEntity<>(loginErrorResponse, HttpStatus.UNAUTHORIZED);
            }
            return ResponseEntity.badRequest().build();
        }
    }
}

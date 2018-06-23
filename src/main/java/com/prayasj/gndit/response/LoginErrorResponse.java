package com.prayasj.gndit.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginErrorResponse extends LoginResponse {
    private String errorMessage = "Invalid Credentials";
}
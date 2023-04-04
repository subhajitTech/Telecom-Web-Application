package com.casestudyserver.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignupRequest {

    @NotBlank
    private String email;

    private String phoneNumber;

    @NotBlank
    private String password;

    private String name;

    public SignupRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

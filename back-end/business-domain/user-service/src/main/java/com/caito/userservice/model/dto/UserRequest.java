package com.caito.userservice.model.dto;

import lombok.Data;

@Data
public class UserRequest {

    private String userName;
    private String email;
    private String password;
    private String roles;
}

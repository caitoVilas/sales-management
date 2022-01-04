package com.caito.userservice.model.dto;

import com.caito.userservice.entity.Role;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UserResponse {

    private Long id;
    private String userName;
    private String email;
    private Set<Role> roles;
    private LocalDateTime created;
    private LocalDateTime updated;
}

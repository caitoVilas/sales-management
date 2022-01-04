package com.caito.userservice.service.contracts;

import com.caito.userservice.model.dto.UserRequest;
import com.caito.userservice.model.dto.UserResponse;

import java.util.List;

public interface UserDAO {

    UserResponse save(UserRequest request);
    UserResponse findById(Long id);
    UserResponse findByUserName(String userName);
    List<UserResponse> findAll();
    void delete(Long id);
}

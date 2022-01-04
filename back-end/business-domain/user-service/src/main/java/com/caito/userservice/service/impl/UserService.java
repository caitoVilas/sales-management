package com.caito.userservice.service.impl;

import com.caito.userservice.mapper.UserResponseMapper;
import com.caito.userservice.model.dto.UserRequest;
import com.caito.userservice.model.dto.UserResponse;
import com.caito.userservice.repository.UserRepository;
import com.caito.userservice.service.contracts.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDAO {

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserResponseMapper responseMapper;


    @Override
    public UserResponse save(UserRequest request) {
        return null;
    }

    @Override
    public UserResponse findById(Long id) {
        return null;
    }

    @Override
    public UserResponse findByUserName(String userName) {
        return null;
    }

    @Override
    public List<UserResponse> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

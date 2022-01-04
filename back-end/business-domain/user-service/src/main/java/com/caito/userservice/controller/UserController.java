package com.caito.userservice.controller;

import com.caito.userservice.model.dto.UserRequest;
import com.caito.userservice.model.dto.UserResponse;
import com.caito.userservice.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales-management/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest request){

        return new ResponseEntity<UserResponse>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id){

        return new ResponseEntity<UserResponse>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll(){

        return new ResponseEntity<List<UserResponse>>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

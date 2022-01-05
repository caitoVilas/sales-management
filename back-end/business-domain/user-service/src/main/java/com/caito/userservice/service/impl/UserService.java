package com.caito.userservice.service.impl;

import com.caito.userservice.constant.ErrorMessage;
import com.caito.userservice.entity.Role;
import com.caito.userservice.entity.User;
import com.caito.userservice.exeption.custom.BadRequestException;
import com.caito.userservice.mapper.UserResponseMapper;
import com.caito.userservice.model.dto.UserRequest;
import com.caito.userservice.model.dto.UserResponse;
import com.caito.userservice.model.enums.RoleName;
import com.caito.userservice.repository.RoleRepository;
import com.caito.userservice.repository.UserRepository;
import com.caito.userservice.service.contracts.UserDAO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDAO {

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserResponseMapper responseMapper;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    @Transactional
    public UserResponse save(UserRequest request) {

        if (repository.existsByEmail(request.getEmail()))
            throw new BadRequestException(ErrorMessage.USR_MAIL_EXISTS);
        if (request.getEmail().isEmpty() || request.getEmail() == null)
            throw new BadRequestException(ErrorMessage.USR_MAIL_EMPTY);
        if (request.getUserName() == null || request.getUserName().isEmpty())
            throw new BadRequestException(ErrorMessage.USR_NAME_EMPTY);
        if (request.getPassword() == null || request.getPassword().isEmpty())
            throw new BadRequestException(ErrorMessage.USR_PASS_EMPTY);
        Set<Role> roles = new HashSet<>();
        if (request.getRoles().contains("admin"))
            roles.add(roleRepository.findByRoleName(RoleName.ROLE_ADMIN).get());
        roles.add(roleRepository.findByRoleName(RoleName.ROLE_USER).get());
        User user = new User();
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRoles(roles);
        repository.save(user);
        return responseMapper.userToResponse(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse findById(Long id) throws NotFoundException {

        User user = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessage.USR_NOT_FOUND + id));

        return responseMapper.userToResponse(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> findAll() {

        List<User> users = repository.findAll();
        return responseMapper.userListToResponseList(users);
    }

    @Override
    public void delete(Long id) throws NotFoundException {

        User user = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessage.USR_NOT_FOUND + id));
        repository.deleteById(user.getId());
    }
}

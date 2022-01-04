package com.caito.userservice.mapper;

import com.caito.userservice.entity.User;
import com.caito.userservice.model.dto.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    UserResponse userToResponse(User user);
    List<UserResponse> userListToResponseList(List<User> users);
}

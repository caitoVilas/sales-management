package com.caito.userservice.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private Integer status;
    private LocalDateTime timestamp;
    private String message;
    private String path;
}

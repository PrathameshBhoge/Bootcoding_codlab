package com.bootcoding.user.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
public class Result {
    private String message;
    private List<User> users;
}

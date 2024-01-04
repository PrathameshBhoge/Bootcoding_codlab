package com.bootcoding.user.command.impl;

import com.bootcoding.user.command.Command;
import com.bootcoding.user.command.validator.CommandValidator;
import com.bootcoding.user.model.Result;

public class DeleteCommand implements Command, CommandValidator {
    @Override
    public Result execute(String[] attributes) {
        // write logic for delete user
        return null;
    }

    @Override
    public boolean validate(String[] attributes) {
        return false;
    }
}

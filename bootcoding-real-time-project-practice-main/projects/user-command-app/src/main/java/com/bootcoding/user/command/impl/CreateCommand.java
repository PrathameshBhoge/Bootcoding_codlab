package com.bootcoding.user.command.impl;

import com.bootcoding.user.command.Command;
import com.bootcoding.user.command.validator.CommandValidator;
import com.bootcoding.user.model.Result;
import com.bootcoding.user.model.User;
import com.bootcoding.user.store.InMemoryStore;
import com.bootcoding.user.utils.Application;
import com.bootcoding.user.utils.ValidationUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateCommand implements Command, CommandValidator {

    @Override
    public Result execute(String[] attributes) throws Exception{
        if(validate(attributes)){
            User user = prepUser(attributes);
            InMemoryStore.users.add(user);
            return Result.builder().message("SUCCESS").users(InMemoryStore.users).build();
        }
        return Result.builder().message("Invalid create command arguments").build();
    }

    private User prepUser(String[] attributes) throws Exception {
        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .build();
        for(int i = 1; i < attributes.length ; i = i + 2) {
            String attrName = attributes[i];
            setAttributeValue(user, attrName, attributes[i + 1]);
        }
        return user;
    }

    @Override
    public boolean validate(String[] attributes) throws Exception{

        if(attributes.length != 9){
            throw new Exception("Please provide all attributes: " +
                    "For ex: \ncreate -n \"Ramesh\" -p 8989 -a " +
                    "\"Nagpur Kdk college cha maaage\" -e \"iamcoder@gmail.com\"");
        }
        if(!attributes[0].equals("create")){
            throw new Exception("Action is not create!");
        }
        boolean isValid = true;
        int i = 1;
        while(isValid && i < attributes.length){
            String attrName = attributes[i];
            isValid = ValidationUtility.validateAttributes(attrName);
            i = i + 2;
        }

        return isValid;
    }

    private void setAttributeValue(User user, String attrName, String value) throws Exception{
        switch (attrName){
            case "-n":
                user.setName(value);
                break;
            case "-p":
                user.setPhone(Long.valueOf(value));
                break;
            case "-a":
                user.setAddress(value);
                break;
            case "-e":
                user.setEmailId(value);
                break;
            default:
                throw new Exception("Invalid command attribute format!");

        }
    }
}

package com.nznotes.noteapp.controller;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nznotes.noteapp.entity.User;
import com.nznotes.noteapp.event.RegistrationCompleteEvent;
import com.nznotes.noteapp.model.UserModel;
import com.nznotes.noteapp.service.UserService;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel) {
        User user = userService.registerUser(userModel);
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(user,"url"));
        return "Success";
    }

}

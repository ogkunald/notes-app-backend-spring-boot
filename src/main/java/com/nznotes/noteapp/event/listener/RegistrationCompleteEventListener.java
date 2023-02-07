package com.nznotes.noteapp.event.listener;

import java.applet.AppletContext;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import com.nznotes.noteapp.entity.User;
import com.nznotes.noteapp.event.RegistrationCompleteEvent;
import com.nznotes.noteapp.service.UserService;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent>{

    @Autowired
    private UserService userService;
    
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // TODO Auto-generated method stub
        //Create verification token for New User with Link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);
    }
    
}

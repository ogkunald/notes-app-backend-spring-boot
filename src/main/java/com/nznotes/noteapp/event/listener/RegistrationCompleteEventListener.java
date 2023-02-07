package com.nznotes.noteapp.event.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.nznotes.noteapp.entity.User;
import com.nznotes.noteapp.event.RegistrationCompleteEvent;
import com.nznotes.noteapp.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
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

        String url =
        event.getApplicationUrl()
                + "/verifyRegistration?token="
                + token;

        //sendVerificationEmail()
        log.info("Click the link to verify your account: {}",
                url);
    }
    
}

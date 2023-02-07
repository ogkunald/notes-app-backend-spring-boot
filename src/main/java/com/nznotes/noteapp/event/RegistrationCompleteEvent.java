package com.nznotes.noteapp.event;

import org.springframework.context.ApplicationEvent;

import com.nznotes.noteapp.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;
    String applicationUrl;

    public RegistrationCompleteEvent(User user,String applicationUrl) {
        super(applicationUrl);
        this.user = user;
        this.applicationUrl = applicationUrl;
        //TODO Auto-generated constructor stub
    }
    
}

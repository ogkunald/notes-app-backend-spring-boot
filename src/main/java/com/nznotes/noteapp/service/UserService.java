package com.nznotes.noteapp.service;

import com.nznotes.noteapp.entity.User;
import com.nznotes.noteapp.model.UserModel;

public interface UserService {

    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

}

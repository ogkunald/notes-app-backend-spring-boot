package com.nznotes.noteapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nznotes.noteapp.entity.User;
import com.nznotes.noteapp.entity.VerificationToken;
import com.nznotes.noteapp.model.UserModel;
import com.nznotes.noteapp.repository.UserRepository;
import com.nznotes.noteapp.repository.VerificationTokenRepository;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        // TODO Auto-generated method stub
        VerificationToken verificationToken = new VerificationToken(user, token);

        VerificationTokenRepository.save(verificationToken);
    }
}

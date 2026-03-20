package com.example.auth_api.services;

import com.example.auth_api.dtos.LoginUserDto;
import com.example.auth_api.model.User;
import com.example.auth_api.repository.UserRepository;
import com.example.auth_api.dtos.RegisterUserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ){
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User signup(RegisterUserDto input){
        User user = new User()
                .setFullName(input.getFullName());

        user = user.setEmail(input.getEmail());
        user = user.setPassword(passwordEncoder.encode(input.getPassword()));
        return userRepository.save(user);
    }
    public User authenticate(LoginUserDto input){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }
}

package com.example.auth_api.dtos;

import lombok.Getter;
import org.jspecify.annotations.Nullable;

public class RegisterUserDto {
    @Getter
    private String email;

    @Getter
    private String password;

    @Getter
    private String fullName;




//    public @Nullable CharSequence getPassword() {
//    }
}

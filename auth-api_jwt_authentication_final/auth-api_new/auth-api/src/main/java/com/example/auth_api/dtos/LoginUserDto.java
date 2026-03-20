package com.example.auth_api.dtos;

import lombok.Getter;
import org.jspecify.annotations.Nullable;

public class LoginUserDto {
    @Getter
    private String email;

    @Getter
    private String password;

}

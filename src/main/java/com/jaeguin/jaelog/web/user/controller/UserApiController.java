package com.jaeguin.jaelog.web.user.controller;

import com.jaeguin.jaelog.domain.user.dto.UserRegisterDto;
import com.jaeguin.jaelog.web.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("user/api/user")
    public Long register(@RequestBody UserRegisterDto userRegisterDto){
        return userService.register(userRegisterDto.toEntity());
    }

}

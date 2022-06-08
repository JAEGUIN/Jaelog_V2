package com.jaeguin.jaelog.web.user.service;

import com.jaeguin.jaelog.domain.user.entity.User;
import com.jaeguin.jaelog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Long register(User user) {
        String password = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(password);
        return userRepository.save(user).getId();
    }

}

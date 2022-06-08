package com.jaeguin.jaelog.web.user.service;

import com.jaeguin.jaelog.domain.user.entity.User;
import com.jaeguin.jaelog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long register(User user) {
        return userRepository.save(user).getId();
    }
}

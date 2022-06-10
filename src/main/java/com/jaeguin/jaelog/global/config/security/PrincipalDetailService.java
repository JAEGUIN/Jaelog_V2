package com.jaeguin.jaelog.global.config.security;

import com.jaeguin.jaelog.domain.user.entity.User;
import com.jaeguin.jaelog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User principal =  userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. " + email));
        return new PrincipalDetail(principal);
    }
}

package com.jaeguin.jaelog.domain.user.repository;

import com.jaeguin.jaelog.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

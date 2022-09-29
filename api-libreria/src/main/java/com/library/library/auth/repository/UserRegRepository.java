package com.library.library.auth.repository;

import com.library.library.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}

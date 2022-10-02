package com.library.library.auth.service;

import com.library.library.auth.repository.UserRegRepository;
import com.library.library.dto.UserDTO;
import com.library.library.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRegRepository userRegRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRegRepository.findByUsername(userName);
        if (userEntity == null){
            throw new UsernameNotFoundException(("Username or password not found"));
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }
}

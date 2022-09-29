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

    public boolean save(UserDTO dto) throws IOException {
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setLastname(dto.getLastname());
        entity.setTel(dto.getTel());
        entity.setAddress(dto.getAddress());
        entity.setFault(0.0);
        entity.setDeleted(false);
        entity.setAccountNonExpired(true);
        entity.setAccountNonLocked(true);
        entity.setCredentialsNonExpired(true);
        entity.setEnabled(true);
        entity = this.userRegRepository.save(entity);
        return entity != null;
    }
}

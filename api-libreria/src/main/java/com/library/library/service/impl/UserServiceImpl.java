package com.library.library.service.impl;

import com.library.library.dto.UserDTO;
import com.library.library.entity.UserEntity;
import com.library.library.mapper.UserMapper;
import com.library.library.repository.UserRepository;
import com.library.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    public UserDTO save(UserDTO dto) {
        UserEntity entity = userMapper.userDTO2Entity(dto);
        UserEntity entitySaved = userRepository.save(entity);
        UserDTO result = userMapper.userEntity2DTO(entitySaved, false);
        return result;
    }
    public UserDTO getUserById(Long id) {
        UserEntity entity = userRepository.getReferenceById(id);
        UserDTO dto = userMapper.userEntity2DTO(entity, true);
        return dto;
    }
    public UserDTO update(Long id, UserDTO user) {
        UserEntity entityId = userRepository.getReferenceById(id);
        UserEntity entity = userMapper.update(entityId,user);
        UserEntity entityUpdated = userRepository.save(entity);
        UserDTO result = userMapper.userEntity2DTO(entityUpdated,false);
        return result;
    }
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}

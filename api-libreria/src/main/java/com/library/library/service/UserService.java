package com.library.library.service;

import com.library.library.dto.UserDTO;
public interface UserService {
    UserDTO save (UserDTO dto);
    UserDTO getUserById(Long id);
    UserDTO update(Long id, UserDTO user);
    void delete (Long id);
}

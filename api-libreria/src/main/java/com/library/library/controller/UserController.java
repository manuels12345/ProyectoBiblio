package com.library.library.controller;

import com.library.library.dto.UserDTO;
import com.library.library.entity.UserEntity;
import com.library.library.repository.UserRepository;
import com.library.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/register")
    public ResponseEntity<UserDTO> userRegister(@RequestBody UserDTO dto){
        UserDTO userSaved = userService.save(dto);
        return ResponseEntity.ok().body(userSaved);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }
    @GetMapping("/email={username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username){
        UserDTO user = userService.getByUsername(username);
        return ResponseEntity.ok().body(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> userUpdate(@PathVariable Long id, @RequestBody UserDTO user) {
        UserDTO userUpdated = userService.update(id, user);
        return ResponseEntity.ok().body(userUpdated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

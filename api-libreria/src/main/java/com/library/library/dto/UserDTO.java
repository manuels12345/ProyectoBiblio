package com.library.library.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;
@Getter
@Setter
@Data
public class UserDTO {
    private Long id;
    private String name;
    @Email(message = "Username must be an email")
    private String username;
    @Size(min = 8)
    private String password;
    private String lastname;
    private String address;
    private String tel;
    private Double fault;
    private Boolean deleted;
    private List<LendingBasicDTO> lendings;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
}


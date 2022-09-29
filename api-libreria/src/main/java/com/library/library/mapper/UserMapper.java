package com.library.library.mapper;

import com.library.library.dto.LendingBasicDTO;
import com.library.library.dto.UserDTO;
import com.library.library.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class UserMapper {
    @Autowired
    private LendingMapper lendingMapper;
    public UserEntity userDTO2Entity(UserDTO dto){
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
        return entity;
    }
    public UserDTO userEntity2DTO(UserEntity entity, Boolean loadLendigns){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setName(entity.getName());
        dto.setLastname(entity.getLastname());
        dto.setTel(entity.getTel());
        dto.setAddress(entity.getAddress());
        dto.setFault(entity.getFault());
        dto.setDeleted(entity.getDeleted());
        dto.setDeleted(false);
        dto.setAccountNonExpired(entity.isAccountNonExpired());
        dto.setAccountNonLocked(entity.isAccountNonLocked());
        dto.setCredentialsNonExpired(entity.isCredentialsNonExpired());
        dto.setEnabled(entity.isEnabled());
        if(loadLendigns) {
            List<LendingBasicDTO> dtos = lendingMapper.lendingEntityList2BasicDTOList(entity.getLendings());
            dto.setLendings(dtos);
        }
        return dto;
    }
    public UserEntity update(UserEntity entity, UserDTO dto){
        entity.setName(dto.getName());
        entity.setLastname(dto.getLastname());
        entity.setTel(dto.getTel());
        entity.setAddress(dto.getAddress());
        return entity;
    }
}

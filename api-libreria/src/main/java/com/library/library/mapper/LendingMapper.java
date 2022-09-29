package com.library.library.mapper;

import com.library.library.dto.LendingBasicDTO;
import com.library.library.dto.LendingDTO;
import com.library.library.entity.BookEntity;
import com.library.library.entity.LendingEntity;
import com.library.library.entity.UserEntity;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class LendingMapper {
    //private static final int MAXDAY = 15;
    public LendingEntity usboDTO2Entity(LendingDTO dto, UserEntity user, BookEntity book){
        LendingEntity entity = new LendingEntity();
        entity.setDateOut(LocalDate.now());
        //entity.setDateReturn(entity.getDateOut().plusDays(MAXDAY));
        entity.setDeleted(false);
        entity.setUserId(user.getId());
        entity.setBookId(book.getId());
        return entity;
    }
    public LendingEntity lendingDTO2Entity(LendingDTO dto, Boolean loadUser, Boolean loadBook){
        LendingEntity entity = new LendingEntity();
        entity.setId(dto.getId());
        if (loadUser){
            entity.setUser(dto.getUser());
        }
        if(loadBook){
            entity.setBook(dto.getBook());
        }
        return entity;
    }
    public LendingEntity lendingBasicEntity2DTO(LendingDTO dto, Boolean loadUser, Boolean loadBook){
        LendingEntity entity = new LendingEntity();
        entity.setId(dto.getId());
        if (loadUser){
            entity.setUser(dto.getUser());
        }
        if(loadBook){
            entity.setBook(dto.getBook());
        }
        return entity;
    }
    public LendingDTO usboEntity2DTO(LendingEntity entity, Boolean loadUser, Boolean loadBook){
        LendingDTO dto = new LendingDTO();
        dto.setId(entity.getId());
        dto.setDateOut(entity.getDateOut());
        dto.setDateReturn(entity.getDateReturn());
        dto.setDeleted(entity.getDeleted());
        if(loadUser){
            dto.setUserId(entity.getUserId());
        }
        if (loadBook){
            dto.setBookId(entity.getBookId());
        }
        return dto;
    }
    public LendingBasicDTO lendingEntity2BasicDTO (LendingEntity entity){
        LendingBasicDTO dto = new LendingBasicDTO();
        dto.setId(entity.getId());
        dto.setDateOut(entity.getDateOut());
        dto.setDateReturn(entity.getDateReturn());
        return dto;
    }
    public LendingEntity lendigBasicDTO2Entity(LendingBasicDTO dto){
        LendingEntity entity = new LendingEntity();
        entity.setId(dto.getId());
        entity.setDateOut(dto.getDateOut());
        entity.setDateReturn(dto.getDateReturn());
        return entity;
    }
    public List<LendingBasicDTO> lendingEntityList2BasicDTOList(List<LendingEntity> entities){
        List<LendingBasicDTO> dtos = new ArrayList<>();
        for(LendingEntity entity: entities){
            if (entity.getDeleted()==false){ // si la reserva no se encuentra borrada de forma lógica, se agregará a la lista
                dtos.add(this.lendingEntity2BasicDTO(entity));
            }
        }
        return dtos;
    }
    public List<LendingEntity> lendingBasicDTOList2EntityList(List<LendingBasicDTO> dtos){
        List<LendingEntity> entities = new ArrayList<>();
        for (LendingBasicDTO dto: dtos){
            entities.add(this.lendigBasicDTO2Entity(dto));
        }
        return entities;
    }
}

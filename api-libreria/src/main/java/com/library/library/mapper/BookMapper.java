package com.library.library.mapper;

import com.library.library.dto.BookDTO;
import com.library.library.dto.LendingBasicDTO;
import com.library.library.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class BookMapper {
    @Autowired
    private LendingMapper lendingMapper;
    public BookEntity bookDTO2Entity(BookDTO dto){
        BookEntity entity = new BookEntity();
        entity.setTitle(dto.getTitle());
        entity.setDate(dto.getDate());
        entity.setAuthor(dto.getAuthor());
        entity.setCategory(dto.getCategory());
        entity.setEdit(dto.getEdit());
        entity.setLang(dto.getLang());
        entity.setPages(dto.getPages());
        entity.setDescription(dto.getDescription());
        entity.setCopy(dto.getCopy());
        entity.setStock(dto.getStock());
        entity.setAvailable(dto.getStock());
        entity.setLost(0);
        entity.setRenovation(0);
        entity.setDeleted(false);
        return entity;
    }
    public BookDTO bookEntity2DTO(BookEntity entity, Boolean loadLendigns){
        BookDTO dto = new BookDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDate(entity.getDate());
        dto.setAuthor(entity.getAuthor());
        dto.setCategory(entity.getCategory());
        dto.setEdit(entity.getEdit());
        dto.setLang(entity.getLang());
        dto.setPages(entity.getPages());
        dto.setDescription(entity.getDescription());
        dto.setCopy(entity.getCopy());
        dto.setStock(entity.getStock());
        dto.setRenovation(entity.getRenovation());
        dto.setAvailable(entity.getAvailable());
        dto.setDeleted(entity.getDeleted());
        dto.setLost(entity.getLost());
        if(loadLendigns){
            List<LendingBasicDTO> dtos = lendingMapper.lendingEntityList2BasicDTOList(entity.getLendings());
            dto.setLendings(dtos);
        }
        return dto;
    }
    public BookEntity update(BookEntity entity, BookDTO dto){
        entity.setTitle(dto.getTitle());
        entity.setDate(dto.getDate());
        entity.setAuthor(dto.getAuthor());
        entity.setCategory(dto.getCategory());
        entity.setEdit(dto.getEdit());
        entity.setLang(dto.getLang());
        entity.setPages(dto.getPages());
        entity.setDescription(dto.getDescription());
        entity.setCopy(dto.getCopy());
        entity.setStock(dto.getStock());
        entity.setAvailable(dto.getAvailable());
        return entity;
    }
    public List<BookDTO> bookEntityList2DTOList( List<BookEntity> entities){
        List<BookDTO> dtos = new ArrayList<>();
        for (BookEntity entity: entities){
            dtos.add(bookEntity2DTO(entity, false));
        }
        return dtos;
    }
}

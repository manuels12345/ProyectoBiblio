package com.library.library.service.impl;

import com.library.library.dto.BookDTO;
import com.library.library.entity.BookEntity;
import com.library.library.mapper.BookMapper;
import com.library.library.repository.BookRepository;
import com.library.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;
    public List<BookDTO> getAll() {
        List<BookEntity> entities = bookRepository.findAll();
        List<BookDTO> dtos = bookMapper.bookEntityList2DTOList(entities);
        return dtos;
    }
    public BookDTO save(BookDTO dto) {
        BookEntity entity = bookMapper.bookDTO2Entity(dto);
        BookEntity entitySaved = bookRepository.save(entity);
        BookDTO result = bookMapper.bookEntity2DTO(entitySaved, false);
        return result;
    }
    public BookDTO getBookById(Long id) {
        BookEntity entity = bookRepository.getReferenceById(id);
        BookDTO dto = bookMapper.bookEntity2DTO(entity, true);
        return dto;
    }
    public BookDTO update(Long id, BookDTO book) {
        BookEntity entityId = bookRepository.getReferenceById(id);
        BookEntity entity = bookMapper.update(entityId,book);
        BookEntity entityUpdated = bookRepository.save(entity);
        BookDTO result = bookMapper.bookEntity2DTO(entityUpdated, false);
        return result;
    }
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    public Boolean isAvailable(Long id) {
        BookEntity entity = bookRepository.getReferenceById(id);
        return entity.getAvailable()>0;
    }
    public void discountUnit(Long id) {
        BookEntity entity = bookRepository.getReferenceById(id);
        entity.setAvailable(entity.getAvailable()-1);
        this.bookRepository.save(entity);
    }
    public void returnUnit(Long id) {
        BookEntity entity = bookRepository.getReferenceById(id);
        entity.setAvailable(entity.getAvailable()+1);
    }
    public void lostUnit(Long id) {
        BookEntity entity = bookRepository.getReferenceById(id);
        entity.setLost(entity.getLost()+1);
    }
}

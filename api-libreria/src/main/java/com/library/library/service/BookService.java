package com.library.library.service;

import com.library.library.dto.BookDTO;
import java.util.List;
public interface BookService {
    List<BookDTO> getAll();
    BookDTO save (BookDTO dto);
    BookDTO getBookById(Long id);
    BookDTO update(Long id, BookDTO book);
    void delete (Long id);
    Boolean isAvailable(Long id);
    void discountUnit(Long id);
    void returnUnit(Long id);
    void lostUnit(Long id);
}

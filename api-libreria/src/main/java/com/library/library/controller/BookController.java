package com.library.library.controller;

import com.library.library.dto.BookDTO;
import com.library.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/all") // GET http://localhost:8080/books/all (no es necesario logearse)
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<BookDTO> books = bookService.getAll();
        return ResponseEntity.ok().body(books);
    }
    @PostMapping // POST http://localhost:8080/books (necesario logearse)
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO dto){
        BookDTO bookSaved = bookService.save(dto);
        return ResponseEntity.ok().body(bookSaved);
    }
    @GetMapping("/{id}") // GET http://localhost:8080/books/{id} (necesario logearse)
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id){
        BookDTO book = bookService.getBookById(id);
        return ResponseEntity.ok().body(book);
    }
    @PutMapping("/{id}") // PUT http://localhost:8080/books/{id} (necesario logearse)
    public ResponseEntity<BookDTO> bookUpdate(@PathVariable Long id, @RequestBody BookDTO book) {
        BookDTO bookUpdated = bookService.update(id, book);
        return ResponseEntity.ok().body(bookUpdated);
    }
    @DeleteMapping("/{id}") // DELETE http://localhost:8080/books/{id} (necesario logearse)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

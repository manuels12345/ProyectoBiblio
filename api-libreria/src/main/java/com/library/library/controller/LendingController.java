package com.library.library.controller;

import com.library.library.dto.LendingDTO;
import com.library.library.service.BookService;
import com.library.library.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("lendings")
public class LendingController{
    @Autowired
    private LendingService lendingService;
    @Autowired
    private BookService bookService;
    @PostMapping("/{idUser}/books/{idBook}") // POST http://localhost:8080/lendings/{idUser}/books/{idBook} (necesario logearse)
    public ResponseEntity<Void>bookReserve(@PathVariable Long idUser, @PathVariable Long idBook,
                                           @RequestBody LendingDTO lending)
    {
        if (!bookService.isAvailable(idBook)){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        lendingService.addReserve(idUser, idBook, lending);
        bookService.discountUnit(idBook);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/returned/{idLending}") // POST http://localhost:8080/lendings/returned/{idLending}
    public ResponseEntity<Void>returnReserve(@PathVariable Long idLending)
    {
        lendingService.returnLending(idLending, false);
        deleteReserve(idLending);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/lost/{idLending}")
    public ResponseEntity<Void>reserveLost(@PathVariable Long idLending)
    {
        lendingService.returnLending(idLending, true);
        deleteReserve(idLending);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/renovations/{idLending}")
    public ResponseEntity<Void>renovationLending(@PathVariable Long idLending)
    {
        lendingService.renovation(idLending);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{idLending}")
    public ResponseEntity<Void>deleteReserve(@PathVariable Long idLending)
    {
        lendingService.delete(idLending);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

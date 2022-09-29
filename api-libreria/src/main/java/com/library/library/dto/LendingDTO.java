package com.library.library.dto;

import com.library.library.entity.BookEntity;
import com.library.library.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
public class LendingDTO {
    private Long id;
    private LocalDate dateOut;
    private LocalDate dateReturn;
    private Boolean deleted;
    private Long userId;
    private Long bookId;
    private UserEntity user;
    private BookEntity book;
}

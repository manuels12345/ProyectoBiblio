package com.library.library.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
public class LendingBasicDTO {
    private Long id;
    private LocalDate dateOut;
    private LocalDate dateReturn;
}

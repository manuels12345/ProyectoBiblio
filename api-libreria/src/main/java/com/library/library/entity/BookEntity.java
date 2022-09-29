package com.library.library.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "book")
@Getter
@Setter
@SQLDelete(sql = "UPDATE book SET deleted = true WHERE id = ? ")
@Where(clause = "deleted=false")
public class BookEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;
    private String author;
    private String category;
    private String edit;
    private String lang;
    private String pages;
    private String description;
    private String copy;
    private Integer stock;
    private Integer available;
    private Integer lost;
    private Boolean deleted;
    private Integer renovation;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    private List<LendingEntity> lendings = new ArrayList<>();
}

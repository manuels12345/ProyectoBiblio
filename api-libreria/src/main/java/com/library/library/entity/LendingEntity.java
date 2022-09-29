package com.library.library.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="lending")
@Getter
@Setter
@SQLDelete(sql = "UPDATE lending SET deleted = true WHERE id = ? ")
public class LendingEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "date_out")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateOut;
    @Column(name = "date_return")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateReturn;
    private Boolean deleted;
    @Column(name="user_id", nullable = false)
    private Long userId;
    @Column(name="book_id", nullable = false)
    private Long bookId;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private BookEntity book;
}

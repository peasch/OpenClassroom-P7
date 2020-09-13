package com.peasch.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="copy")
@Getter
@Setter
@NoArgsConstructor
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="available")
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "fk_book")
    private Book book;


    @ManyToOne
    @JoinColumn(name = "fk_library")
    private Library library;
}

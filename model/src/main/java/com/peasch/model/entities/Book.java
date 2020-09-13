package com.peasch.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="book")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="summary")
    private String summary;

    @ManyToOne
    @JoinColumn(name = "fk_author")
    private Author author;

     @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private Set<Copy> copiesOfBook = new HashSet<>();
}

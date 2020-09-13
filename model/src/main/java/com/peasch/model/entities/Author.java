package com.peasch.model.entities;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="author")
@Getter  @Setter
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "birth_date")
    private String birthDate;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Book> books = new HashSet<>();
}

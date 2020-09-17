package com.peasch.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="library")
@Getter
@Setter
@NoArgsConstructor
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="adresse")
    private String adress;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "library",fetch = FetchType.LAZY)
    private Set<User> Users = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "library",fetch = FetchType.LAZY)
    private Set<Copy> copies = new HashSet<>();

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", Users=" + Users +
                ", copies=" + copies +
                '}';
    }
}

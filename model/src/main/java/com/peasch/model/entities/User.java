package com.peasch.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "birthdate")
    private String birthDate;

    @ManyToOne
    @JoinColumn(name = "fk_library")
    private Library library;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Borrowing> borrowings = new HashSet<>();

    public User() {
    }

    public User(int id, String userName, String password, String email, String name, String firstName, String birthDate, Library library, Set<Borrowing> borrowings) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.library = library;
        this.borrowings = borrowings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Set<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(Set<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", library=" + library +
                ", borrowings=" + borrowings +
                '}';
    }
}



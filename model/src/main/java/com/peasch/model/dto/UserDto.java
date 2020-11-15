package com.peasch.model.dto;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;

    private String userName;

    private String password;

    private String email;

    private String name;

    private String firstName;

    private String birthDate;

    private Set<BorrowingDto> borrowings = new HashSet<>();

    private Set <RoleDto> roles = new HashSet <> ();

    public UserDto() {
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

    public Set<BorrowingDto> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(Set<BorrowingDto> borrowings) {
        this.borrowings = borrowings;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }
}

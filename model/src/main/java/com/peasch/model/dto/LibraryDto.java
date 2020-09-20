package com.peasch.model.dto;
import com.peasch.model.entities.Copy;
import com.peasch.model.entities.User;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class LibraryDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String adress;
    private String phone;
    private String email;
    private Set<User> Users = new HashSet<>();
    private Set<Copy> copies = new HashSet<>();

    public LibraryDto() {
    }

    public LibraryDto(int id, String name, String adress, String phone, String email, Set<User> users, Set<Copy> copies) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
        Users = users;
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "LibraryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", Users=" + Users +
                ", copies=" + copies +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<User> getUsers() {
        return Users;
    }

    public void setUsers(Set<User> users) {
        Users = users;
    }

    public Set<Copy> getCopies() {
        return copies;
    }

    public void setCopies(Set<Copy> copies) {
        this.copies = copies;
    }
}

package com.peasch.model.dto;

import com.peasch.model.entities.User;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class RoleDto implements Serializable {

    private Integer id;
    private String role;
    private Set<UserDto> users =new HashSet<>();

    public RoleDto() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<UserDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDto> users) {
        this.users = users;
    }
}

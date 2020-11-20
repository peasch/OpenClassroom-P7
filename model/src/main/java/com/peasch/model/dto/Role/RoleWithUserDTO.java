package com.peasch.model.dto.Role;

import com.peasch.model.entities.User;

public class RoleWithUserDTO extends RoleDto {

    private User user;

    public RoleWithUserDTO() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

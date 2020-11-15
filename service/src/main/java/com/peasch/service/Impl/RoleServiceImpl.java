package com.peasch.service.Impl;

import com.peasch.model.dto.RoleDto;
import com.peasch.model.dto.mapper.RoleMapper;
import com.peasch.model.entities.Role;
import com.peasch.service.RoleService;
import com.peasch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleMapper roleMapper;

   /* Set<RoleDto> FindRolesOfUserByUserName(String userName) {
    Set<Role> roles = userService.findUserByUserName(userName).getRoles();
    for(Role role :roles){

    }
    }*/
}

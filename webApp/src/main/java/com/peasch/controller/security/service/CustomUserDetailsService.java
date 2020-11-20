package com.peasch.controller.security.service;

import com.googlecode.jmapper.JMapper;
import com.peasch.model.dto.Role.RoleDto;
import com.peasch.model.dto.User.UserDto;
import com.peasch.model.dto.User.UserWithRoleDTO;
import com.peasch.model.entities.Role;
import com.peasch.repository.dao.RoleDao;
import com.peasch.service.RoleService;
import com.peasch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserWithRoleDTO user = userService.findUserByUserNameWithRole(username);
        if(user != null) {
            List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }
    public void saveUser(UserWithRoleDTO user) { // Pour sauver un nouvel utilisateur
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RoleDto userRole = roleService.findByRole("USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userService.save(user);
    }



    public Set<GrantedAuthority> getAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet<GrantedAuthority>(authentication.getAuthorities()));
    }

    private List<GrantedAuthority> getUserAuthority(Set<RoleDto> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        });
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }
    private UserDetails buildUserForAuthentication(UserWithRoleDTO user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }
}

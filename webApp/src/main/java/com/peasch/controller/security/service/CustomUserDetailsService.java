package com.peasch.controller.security.service;

import com.peasch.model.dto.RoleDto;
import com.peasch.model.dto.UserDto;
import com.peasch.model.entities.Role;
import com.peasch.model.entities.User;
import com.peasch.repository.dao.RoleDao;
import com.peasch.repository.dao.UserDao;
import com.peasch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userService.findUserByUserName(username);
        if(user != null) {
            List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }
    public void saveUser(UserDto user) { // Pour sauver un nouvel utilisateur
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleDao.findByRole("USER");
        user.setRoles(new HashSet(Arrays.asList(userRole)));
        userService.save(user);
    }

    public Set<GrantedAuthority> getAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet<GrantedAuthority>(authentication.getAuthorities()));
    }

    private List<GrantedAuthority> getUserAuthority(Set<RoleDto> userRoles) { // Nous créons les rôles reconnus par Spring Security qui permettra ou non
        Set<GrantedAuthority> roles = new HashSet<>(); // à l'utilisateur d'accéder à une page.
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        });
        return new ArrayList<>(roles);

    }
    private UserDetails buildUserForAuthentication(UserDto user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}

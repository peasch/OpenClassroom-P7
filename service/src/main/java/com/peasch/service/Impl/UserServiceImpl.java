package com.peasch.service.Impl;

import com.googlecode.jmapper.JMapper;
import com.peasch.model.dto.Borrowings.BorrowingWithAllDTO;
import com.peasch.model.dto.Role.RoleDto;
import com.peasch.model.dto.User.UserDto;
import com.peasch.model.dto.User.UserWithAllDTO;
import com.peasch.model.dto.User.UserWithRoleDTO;
import com.peasch.model.entities.Borrowing;
import com.peasch.model.entities.Role;
import com.peasch.model.entities.User;
import com.peasch.repository.dao.UserDao;
import com.peasch.service.BorrowingService;
import com.peasch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private JMapper<UserDto, User> userToDTOMapper;
    @Autowired
    private JMapper<User, UserDto>  dtoToUserMapper;
    @Autowired
    private JMapper<RoleDto, Role> roleToDTOMapper;
    @Autowired
    private JMapper<BorrowingWithAllDTO, Borrowing> borrowingWithAllToDTOMapper;
    @Autowired
    private JMapper<UserWithAllDTO, User>  userWithAllToDTOMapper;
    @Autowired
    private JMapper<UserWithRoleDTO, User>  userWithRoleToDTOMapper;

    @Autowired
    private BorrowingService borrowingService;

    public List<UserDto> getUsers() {
        List<User> users = userDao.findAll();
        return users.stream().map(x -> userToDTOMapper.getDestination(x)).collect(Collectors.toList());
    }

    public UserDto findById(Integer id) {
        User user = userDao.findById(id).get();
        UserDto userDto = userToDTOMapper.getDestination(user);
        return userDto;

    }

    public UserWithRoleDTO findByIdWithRole(Integer id) {
        User user = userDao.findById(id).get();
        UserWithRoleDTO userDto = (UserWithRoleDTO) userToDTOMapper.getDestination(user);
        Set<Role> roles = user.getRoles();
        userDto.setRoles(roles.stream().map(x->roleToDTOMapper.getDestination(x)).collect(Collectors.toSet()));
        return userDto;

    }

    public UserDto save(UserDto userDto) {
        return userToDTOMapper.getDestination(userDao.save(dtoToUserMapper.getDestination(userDto)));

    }

    public UserWithAllDTO findUserByUserName(String userName) {
        User user = userDao.findByUserName(userName);
        UserWithAllDTO userDto = userWithAllToDTOMapper.getDestination(user);
        Set<Role> roles = user.getRoles();
        userDto.setRoles(roles.stream().map(x->roleToDTOMapper.getDestination(x)).collect(Collectors.toSet()));
        userDto.setBorrowings(borrowingService.findBorrowingsByUserId(user.getId()));

        return userDto;
    }

    public UserWithRoleDTO findUserByUserNameWithRole(String userName) {
        User user = userDao.findByUserName(userName);
        UserWithRoleDTO userDto = userWithRoleToDTOMapper.getDestination(user);
        Set<Role> roles = user.getRoles();
        userDto.setRoles(roles.stream().map(x->roleToDTOMapper.getDestination(x)).collect(Collectors.toSet()));


        return userDto;
    }
}

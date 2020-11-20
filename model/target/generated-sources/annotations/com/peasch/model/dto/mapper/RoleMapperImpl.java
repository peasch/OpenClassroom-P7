package com.peasch.model.dto.mapper;

import com.peasch.model.dto.Role.RoleDto;
import com.peasch.model.dto.User.UserDto;
import com.peasch.model.entities.Role;
import com.peasch.model.entities.User;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-13T17:10:44+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Role fromDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setRole( roleDto.getRole() );
        role.setUsers( userDtoSetToUserSet( roleDto.getUsers() ) );

        return role;
    }

    @Override
    public RoleDto fromRoleToDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setRole( role.getRole() );

        return roleDto;
    }

    protected Set<User> userDtoSetToUserSet(Set<UserDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<User> set1 = new HashSet<User>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( UserDto userDto : set ) {
            set1.add( userMapper.fromDtoToUser( userDto ) );
        }

        return set1;
    }
}

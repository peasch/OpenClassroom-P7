package com.peasch.model.dto.mapper;

import com.peasch.model.dto.BorrowingDto;
import com.peasch.model.dto.RoleDto;
import com.peasch.model.dto.UserDto;
import com.peasch.model.entities.Borrowing;
import com.peasch.model.entities.Role;
import com.peasch.model.entities.User;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-13T17:17:33+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private BorrowingMapper borrowingMapper;

    @Override
    public User fromDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUserName( userDto.getUserName() );
        user.setPassword( userDto.getPassword() );
        user.setEmail( userDto.getEmail() );
        user.setName( userDto.getName() );
        user.setFirstName( userDto.getFirstName() );
        user.setBirthDate( userDto.getBirthDate() );
        user.setBorrowings( borrowingDtoSetToBorrowingSet( userDto.getBorrowings() ) );
        user.setRoles( roleDtoSetToRoleSet( userDto.getRoles() ) );

        return user;
    }

    @Override
    public UserDto fromUserToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUserName( user.getUserName() );
        userDto.setPassword( user.getPassword() );
        userDto.setEmail( user.getEmail() );
        userDto.setName( user.getName() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setBirthDate( user.getBirthDate() );

        return userDto;
    }

    @Override
    public Set<RoleDto> fromRolesToDto(Set<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        Set<RoleDto> set = new HashSet<RoleDto>( Math.max( (int) ( roles.size() / .75f ) + 1, 16 ) );
        for ( Role role : roles ) {
            set.add( roleMapper.fromRoleToDto( role ) );
        }

        return set;
    }

    @Override
    public Set<BorrowingDto> fromBorrowingsToDto(Set<Borrowing> borrowings) {
        if ( borrowings == null ) {
            return null;
        }

        Set<BorrowingDto> set = new HashSet<BorrowingDto>( Math.max( (int) ( borrowings.size() / .75f ) + 1, 16 ) );
        for ( Borrowing borrowing : borrowings ) {
            set.add( borrowingMapper.fromBorrowingToDto( borrowing ) );
        }

        return set;
    }

    protected Set<Borrowing> borrowingDtoSetToBorrowingSet(Set<BorrowingDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Borrowing> set1 = new HashSet<Borrowing>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( BorrowingDto borrowingDto : set ) {
            set1.add( borrowingMapper.fromDtoToBorrowing( borrowingDto ) );
        }

        return set1;
    }

    protected Set<Role> roleDtoSetToRoleSet(Set<RoleDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new HashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleDto roleDto : set ) {
            set1.add( roleMapper.fromDtoToRole( roleDto ) );
        }

        return set1;
    }
}

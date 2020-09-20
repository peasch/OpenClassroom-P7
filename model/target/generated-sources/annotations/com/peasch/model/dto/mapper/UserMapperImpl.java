package com.peasch.model.dto.mapper;

import com.peasch.model.dto.UserDto;
import com.peasch.model.entities.Borrowing;
import com.peasch.model.entities.User;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-20T11:52:02+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

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
        user.setLibrary( userDto.getLibrary() );
        Set<Borrowing> set = userDto.getBorrowings();
        if ( set != null ) {
            user.setBorrowings( new HashSet<Borrowing>( set ) );
        }

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
        userDto.setLibrary( user.getLibrary() );
        Set<Borrowing> set = user.getBorrowings();
        if ( set != null ) {
            userDto.setBorrowings( new HashSet<Borrowing>( set ) );
        }

        return userDto;
    }
}

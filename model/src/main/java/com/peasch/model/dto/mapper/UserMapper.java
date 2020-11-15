package com.peasch.model.dto.mapper;

import com.peasch.model.dto.BorrowingDto;
import com.peasch.model.dto.RoleDto;
import com.peasch.model.entities.Borrowing;
import com.peasch.model.entities.Role;
import com.peasch.model.entities.User;
import com.peasch.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CopyMapper.class,RoleMapper.class, CategoryMapper.class, AuthorMapper.class, LibraryMapper.class, BorrowingMapper.class})
public interface UserMapper {
    User fromDtoToUser(UserDto userDto);

    @Mapping(source = "roles", target = "roles", ignore = true)
    @Mapping(source = "borrowings", target = "borrowings", ignore = true)
    UserDto fromUserToDto (User user);

    Set<RoleDto> fromRolesToDto(Set<Role> roles);
    Set<BorrowingDto> fromBorrowingsToDto(Set<Borrowing> borrowings);
}

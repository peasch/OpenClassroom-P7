package com.peasch.model.dto.mapper;

import com.peasch.model.dto.RoleDto;
import com.peasch.model.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring",uses={UserMapper.class})
public interface RoleMapper {

    Role fromDtoToRole(RoleDto roleDto);
    @Mapping(source = "users", target = "users", ignore = true)
    RoleDto fromRoleToDto(Role role);


}

package com.peasch.model.dto.mapper;

import com.peasch.model.dto.RoleDto;
import com.peasch.model.entities.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role fromDtoToRole(RoleDto roleDto);
    RoleDto fromRoleToDto(Role role);

}

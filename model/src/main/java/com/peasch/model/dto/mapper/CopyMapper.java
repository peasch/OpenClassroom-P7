package com.peasch.model.dto.mapper;

import com.peasch.model.dto.CopyDto;
import com.peasch.model.entities.Copy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CopyMapper {

    CopyDto fromCopyToDto (Copy copy);
    Copy fromDtoToCopy (CopyDto copyDto);
}

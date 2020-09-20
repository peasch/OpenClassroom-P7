package com.peasch.model.dto.mapper;

import com.peasch.model.dto.LibraryDto;
import com.peasch.model.entities.Library;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibraryMapper {

    Library fromDtoToLibrary (LibraryDto libraryDto);
    LibraryDto fromLibraryToDto (Library library);
}

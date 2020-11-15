package com.peasch.model.dto.mapper;

import com.peasch.model.dto.LibraryDto;
import com.peasch.model.entities.Library;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses={BookMapper.class})
public interface LibraryMapper {

    Library fromDtoToLibrary (LibraryDto libraryDto);
    /*@Mapping(source = "category",target = "category",ignore=true)*/
    @Mapping(source = "copies",target = "copies",ignore=true)
    LibraryDto fromLibraryToDto (Library library);
}

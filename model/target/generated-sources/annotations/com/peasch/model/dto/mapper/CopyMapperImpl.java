package com.peasch.model.dto.mapper;

import com.peasch.model.dto.copies.CopyDto;
import com.peasch.model.entities.Copy;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-13T15:12:47+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class CopyMapperImpl implements CopyMapper {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public CopyDto fromCopyToDto(Copy copy) {
        if ( copy == null ) {
            return null;
        }

        CopyDto copyDto = new CopyDto();

        copyDto.setId( copy.getId() );
        copyDto.setAvailable( copy.isAvailable() );
        copyDto.setBook( bookMapper.fromBookToDto( copy.getBook() ) );
        copyDto.setLibrary( libraryMapper.fromLibraryToDto( copy.getLibrary() ) );

        return copyDto;
    }

    @Override
    public Copy fromDtoToCopy(CopyDto copyDto) {
        if ( copyDto == null ) {
            return null;
        }

        Copy copy = new Copy();

        copy.setId( copyDto.getId() );
        copy.setAvailable( copyDto.isAvailable() );
        copy.setBook( bookMapper.fromDtoToBook( copyDto.getBook() ) );
        copy.setLibrary( libraryMapper.fromDtoToLibrary( copyDto.getLibrary() ) );

        return copy;
    }
}

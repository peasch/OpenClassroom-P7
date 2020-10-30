package com.peasch.model.dto.mapper;

import com.peasch.model.dto.CopyDto;
import com.peasch.model.entities.Copy;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-26T09:14:56+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class CopyMapperImpl implements CopyMapper {

    @Override
    public CopyDto fromCopyToDto(Copy copy) {
        if ( copy == null ) {
            return null;
        }

        CopyDto copyDto = new CopyDto();

        copyDto.setId( copy.getId() );
        copyDto.setAvailable( copy.isAvailable() );
        copyDto.setBook( copy.getBook() );
        copyDto.setLibrary( copy.getLibrary() );

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
        copy.setBook( copyDto.getBook() );
        copy.setLibrary( copyDto.getLibrary() );

        return copy;
    }
}

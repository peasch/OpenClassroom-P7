package com.peasch.model.dto.mapper;

import com.peasch.model.dto.LibraryDto;
import com.peasch.model.entities.Copy;
import com.peasch.model.entities.Library;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-04T14:26:47+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class LibraryMapperImpl implements LibraryMapper {

    @Override
    public Library fromDtoToLibrary(LibraryDto libraryDto) {
        if ( libraryDto == null ) {
            return null;
        }

        Library library = new Library();

        library.setId( libraryDto.getId() );
        library.setName( libraryDto.getName() );
        library.setAdress( libraryDto.getAdress() );
        library.setPhone( libraryDto.getPhone() );
        library.setEmail( libraryDto.getEmail() );
        Set<Copy> set = libraryDto.getCopies();
        if ( set != null ) {
            library.setCopies( new HashSet<Copy>( set ) );
        }

        return library;
    }

    @Override
    public LibraryDto fromLibraryToDto(Library library) {
        if ( library == null ) {
            return null;
        }

        LibraryDto libraryDto = new LibraryDto();

        libraryDto.setId( library.getId() );
        libraryDto.setName( library.getName() );
        libraryDto.setAdress( library.getAdress() );
        libraryDto.setPhone( library.getPhone() );
        libraryDto.setEmail( library.getEmail() );
        Set<Copy> set = library.getCopies();
        if ( set != null ) {
            libraryDto.setCopies( new HashSet<Copy>( set ) );
        }

        return libraryDto;
    }
}

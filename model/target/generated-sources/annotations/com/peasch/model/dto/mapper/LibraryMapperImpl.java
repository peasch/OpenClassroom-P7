package com.peasch.model.dto.mapper;

import com.peasch.model.dto.CopyDto;
import com.peasch.model.dto.LibraryDto;
import com.peasch.model.entities.Copy;
import com.peasch.model.entities.Library;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-13T15:12:48+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class LibraryMapperImpl implements LibraryMapper {

    @Autowired
    private BookMapper bookMapper;

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
        library.setCopies( copyDtoSetToCopySet( libraryDto.getCopies() ) );

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

        return libraryDto;
    }

    protected Copy copyDtoToCopy(CopyDto copyDto) {
        if ( copyDto == null ) {
            return null;
        }

        Copy copy = new Copy();

        copy.setId( copyDto.getId() );
        copy.setAvailable( copyDto.isAvailable() );
        copy.setBook( bookMapper.fromDtoToBook( copyDto.getBook() ) );
        copy.setLibrary( fromDtoToLibrary( copyDto.getLibrary() ) );

        return copy;
    }

    protected Set<Copy> copyDtoSetToCopySet(Set<CopyDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Copy> set1 = new HashSet<Copy>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CopyDto copyDto : set ) {
            set1.add( copyDtoToCopy( copyDto ) );
        }

        return set1;
    }
}

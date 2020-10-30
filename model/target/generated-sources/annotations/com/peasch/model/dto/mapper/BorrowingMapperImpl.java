package com.peasch.model.dto.mapper;

import com.peasch.model.dto.BorrowingDto;
import com.peasch.model.entities.Borrowing;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-26T09:14:57+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class BorrowingMapperImpl implements BorrowingMapper {

    @Override
    public Borrowing fromDtoToBorrowing(BorrowingDto borrowingDto) {
        if ( borrowingDto == null ) {
            return null;
        }

        Borrowing borrowing = new Borrowing();

        borrowing.setId( borrowingDto.getId() );
        borrowing.setBorrowingDate( borrowingDto.getBorrowingDate() );
        borrowing.setReturnDate( borrowingDto.getReturnDate() );
        borrowing.setExtended( borrowingDto.isExtended() );
        borrowing.setReturned( borrowingDto.getReturned() );
        borrowing.setUser( borrowingDto.getUser() );
        borrowing.setCopy( borrowingDto.getCopy() );

        return borrowing;
    }

    @Override
    public BorrowingDto fromBorrowingToDto(Borrowing borrowing) {
        if ( borrowing == null ) {
            return null;
        }

        BorrowingDto borrowingDto = new BorrowingDto();

        borrowingDto.setId( borrowing.getId() );
        borrowingDto.setBorrowingDate( borrowing.getBorrowingDate() );
        borrowingDto.setReturnDate( borrowing.getReturnDate() );
        borrowingDto.setExtended( borrowing.isExtended() );
        borrowingDto.setUser( borrowing.getUser() );
        borrowingDto.setCopy( borrowing.getCopy() );
        borrowingDto.setReturned( borrowing.getReturned() );

        return borrowingDto;
    }
}

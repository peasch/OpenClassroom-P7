package com.peasch.model.dto.mapper;

import com.peasch.model.dto.BorrowingDto;
import com.peasch.model.entities.Borrowing;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-13T15:46:42+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class BorrowingMapperImpl implements BorrowingMapper {

    @Autowired
    private CopyMapper copyMapper;
    @Autowired
    private UserMapper userMapper;

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
        borrowing.setUser( userMapper.fromDtoToUser( borrowingDto.getUser() ) );
        borrowing.setCopy( copyMapper.fromDtoToCopy( borrowingDto.getCopy() ) );

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
        borrowingDto.setReturned( borrowing.getReturned() );

        return borrowingDto;
    }
}

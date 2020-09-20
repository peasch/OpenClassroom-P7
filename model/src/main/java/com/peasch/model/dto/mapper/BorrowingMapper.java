package com.peasch.model.dto.mapper;

import com.peasch.model.dto.BorrowingDto;
import com.peasch.model.entities.Borrowing;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BorrowingMapper {

    Borrowing fromDtoToBorrowing (BorrowingDto borrowingDto);
    BorrowingDto fromBorrowingToDto(Borrowing borrowing);
}

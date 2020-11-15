package com.peasch.model.dto.mapper;

import com.peasch.model.dto.BorrowingDto;
import com.peasch.model.dto.CopyDto;
import com.peasch.model.dto.UserDto;
import com.peasch.model.entities.Borrowing;
import com.peasch.model.entities.Copy;
import com.peasch.model.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CopyMapper.class,
        CategoryMapper.class, AuthorMapper.class, LibraryMapper.class, UserMapper.class})
public interface BorrowingMapper {

    Borrowing fromDtoToBorrowing(BorrowingDto borrowingDto);
    @Mapping(source = "user", target = "user", ignore = true)
    @Mapping(source = "copy", target = "copy", ignore = true)
    BorrowingDto fromBorrowingToDto(Borrowing borrowing);
}

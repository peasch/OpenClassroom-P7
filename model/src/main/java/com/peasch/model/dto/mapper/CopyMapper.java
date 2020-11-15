package com.peasch.model.dto.mapper;

import com.peasch.model.dto.CopyDto;
import com.peasch.model.entities.Copy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE, uses={BookMapper.class,CategoryMapper.class,AuthorMapper.class,LibraryMapper.class,BorrowingMapper.class})
public interface CopyMapper {

    CopyDto fromCopyToDto (Copy copy);

    Copy fromDtoToCopy (CopyDto copyDto);

}

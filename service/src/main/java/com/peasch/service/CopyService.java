package com.peasch.service;

import com.peasch.model.dto.CopyDto;
import com.peasch.model.entities.Copy;

import java.util.List;
import java.util.Map;

public interface CopyService {

    List<Copy> getCopies();

    Copy findById(Integer id);

    Copy save(Copy copy);

    List<CopyDto> findCopiesByBook_IdAndAvailable(Integer bookId,Integer libId);
    Map<Integer,Integer> findCopiesInLibrary(Integer bookId);
}


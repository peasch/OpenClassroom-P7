package com.peasch.service;

import com.peasch.model.dto.LibraryDto;
import com.peasch.model.entities.Library;

import java.util.List;

public interface LibraryService {
    List<LibraryDto> getLibraries();


    Library findById(Integer id);

    Library save(Library library);
}

package com.peasch.service.Impl;

import com.peasch.model.dto.LibraryDto;
import com.peasch.model.dto.mapper.LibraryMapper;
import com.peasch.model.entities.Library;
import com.peasch.model.entities.User;
import com.peasch.repository.dao.LibraryDao;
import com.peasch.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private LibraryDao libraryDao;

    @Autowired
    private LibraryMapper mapper;

    public List<LibraryDto> getLibraries(){
        List<LibraryDto> libs = new ArrayList<>();
        List<Library> libraries = libraryDao.findAll();
        for (Library library:libraries){
            libs.add(mapper.fromLibraryToDto(library));
        }
        return libs;
    }

    public Library findById(Integer id){
        return libraryDao.findById(id).get();

    }

    public Library save(Library library){
        return libraryDao.save(library);
    }

}

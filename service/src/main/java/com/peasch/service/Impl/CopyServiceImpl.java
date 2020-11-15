package com.peasch.service.Impl;

import com.peasch.model.dto.CopyDto;
import com.peasch.model.dto.LibraryDto;
import com.peasch.model.dto.mapper.BookMapper;
import com.peasch.model.dto.mapper.CopyMapper;
import com.peasch.model.dto.mapper.LibraryMapper;
import com.peasch.model.entities.Copy;
import com.peasch.model.entities.Library;
import com.peasch.repository.dao.CopyDao;
import com.peasch.repository.dao.LibraryDao;
import com.peasch.service.AuthorService;
import com.peasch.service.BookService;
import com.peasch.service.CopyService;
import com.peasch.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CopyServiceImpl implements CopyService {
    @Autowired
    private CopyDao copyDao;
    @Autowired
    private CopyMapper mapper;

    @Autowired
    private LibraryService libService;

    @Autowired
    private BookService bookService;

    public List<Copy> getCopies(){
        return copyDao.findAll();
    }

    public CopyDto findById(Integer id){

        CopyDto copy =mapper.fromCopyToDto(copyDao.findById(id).get());
        copy.setBook(bookService.findById(copyDao.findById(id).get().getBook().getId()));
        copy.setLibrary(libService.findById(copyDao.findById(id).get().getLibrary().getId()));
        return copy;

    }

    public Copy save(Copy copy){
        return copyDao.save(copy);
    }

    public List<CopyDto> findCopiesByBook_IdAndAvailable(Integer bookId,Integer libId){
        List<CopyDto> copiesAvailable = new ArrayList<>();
        List<Copy> copies = copyDao.findCopiesByBook_IdAndAvailableAndLibrary_Id(bookId,true,libId);


        for( Copy copy:copies){
            copiesAvailable.add(mapper.fromCopyToDto(copy));
        }
        return copiesAvailable;
    }

    public Map<Integer,Integer> findCopiesInLibrary(Integer bookId){
        List<LibraryDto> libraries = libService.getLibraries();
        Map<Integer,Integer> copiesInLibraries = new HashMap<>();
        for(LibraryDto library:libraries){
            copiesInLibraries.put(library.getId(),findCopiesByBook_IdAndAvailable(bookId,library.getId()).size());
        }
        return copiesInLibraries;
    }
}

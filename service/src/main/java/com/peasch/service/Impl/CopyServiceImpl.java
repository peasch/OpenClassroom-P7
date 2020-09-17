package com.peasch.service.Impl;

import com.peasch.model.entities.Copy;
import com.peasch.model.entities.Library;
import com.peasch.repository.dao.CopyDao;
import com.peasch.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyServiceImpl implements CopyService {
    @Autowired
    private CopyDao copyDao;

    public List<Copy> getCopies(){
        return copyDao.findAll();
    }

    public Copy findById(Integer id){
        return copyDao.findById(id).get();

    }

    public Copy save(Copy copy){
        return copyDao.save(copy);
    }
}

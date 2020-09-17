package com.peasch.service;

import com.peasch.model.entities.Copy;

import java.util.List;

public interface CopyService {

    List<Copy> getCopies();

    Copy findById(Integer id);

    Copy save(Copy copy);
}

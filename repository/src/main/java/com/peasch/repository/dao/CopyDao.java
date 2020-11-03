package com.peasch.repository.dao;

import com.peasch.model.dto.CopyDto;
import com.peasch.model.entities.Copy;
import com.peasch.model.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CopyDao extends JpaRepository<Copy, Integer> {

    List<Copy> findCopiesByBook_IdAndAvailableAndLibrary_Id(int book_id, boolean available, int library_id);
}

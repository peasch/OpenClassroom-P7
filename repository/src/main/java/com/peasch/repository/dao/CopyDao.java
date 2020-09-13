package com.peasch.repository.dao;

import com.peasch.model.entities.Copy;
import com.peasch.model.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopyDao extends JpaRepository<Copy, Integer> {
}

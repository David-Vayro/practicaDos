package com.codigo.david_vara.dao;

import com.codigo.david_vara.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorDAO extends JpaRepository <AutorEntity, Long> {
}

package com.codigo.david_vara.dao;

import com.codigo.david_vara.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroDAO extends JpaRepository<LibroEntity, Long> {
}

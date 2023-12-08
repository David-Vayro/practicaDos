package com.codigo.david_vara.dao;

import com.codigo.david_vara.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDAO extends JpaRepository<CategoriaEntity,Long> {
}

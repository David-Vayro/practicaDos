package com.codigo.david_vara.service;

import com.codigo.david_vara.entity.AutorEntity;
import com.codigo.david_vara.entity.CategoriaEntity;
import com.codigo.david_vara.request.CategoriaRequest;

import java.util.List;

public interface CategoriaService {
    List<CategoriaEntity> obtenerTodos();
    CategoriaEntity  obtenerCategoriaPorId(Long id) throws Exception;
    CategoriaEntity crearCategoria(CategoriaEntity categoria);
    CategoriaEntity actualizarCategoria(Long id, CategoriaRequest categoriaRequest) throws Exception;
    CategoriaEntity eliminarCategoria(Long id) throws Exception;
}

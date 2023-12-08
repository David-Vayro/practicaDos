package com.codigo.david_vara.service;

import com.codigo.david_vara.entity.AutorEntity;
import com.codigo.david_vara.request.AutorRequest;

import java.util.List;

public interface AutorService {
    List<AutorEntity> obtenerTodos();
    AutorEntity obtenerAutorPorId(Long id) throws Exception;
    AutorEntity crearAutor(AutorEntity autor);
    AutorEntity actualizarAutor(Long id, AutorRequest autorRequest) throws Exception;
    AutorEntity eliminarAutor(Long id) throws Exception;

}

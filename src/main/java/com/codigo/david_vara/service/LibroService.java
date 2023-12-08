package com.codigo.david_vara.service;

import com.codigo.david_vara.entity.AutorEntity;
import com.codigo.david_vara.entity.LibroEntity;
import com.codigo.david_vara.request.LibroRequest;

import java.util.List;

public interface LibroService {
    List<LibroEntity> obtenerTodos();
    LibroEntity obtenerLibrorPorId(Long id) throws Exception;
    LibroEntity crearLibro(LibroEntity libro);
    LibroEntity actualizarLibro(Long id, LibroRequest libroRequest) throws Exception;
    LibroEntity eliminarLibro(Long id) throws Exception;
}

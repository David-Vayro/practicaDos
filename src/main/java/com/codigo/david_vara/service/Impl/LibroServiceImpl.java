package com.codigo.david_vara.service.Impl;

import com.codigo.david_vara.dao.LibroDAO;
import com.codigo.david_vara.entity.LibroEntity;
import com.codigo.david_vara.request.LibroRequest;
import com.codigo.david_vara.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroDAO libroDAO;
    @Override
    public List<LibroEntity> obtenerTodos() {
        return libroDAO.findAll();
    }

    @Override
    public LibroEntity obtenerLibrorPorId(Long id) throws Exception {
        Optional<LibroEntity> libro = libroDAO.findById(id);
        if (libro.isPresent()){
            return libro.get();
        }
        return null;
    }

    @Override
    public LibroEntity crearLibro(LibroEntity libro) {
        return libroDAO.save(libro);
    }

    @Override
    public LibroEntity actualizarLibro(Long id, LibroRequest libroRequest)throws Exception {
        LibroEntity libroEntity = obtenerLibrorPorId(id);
        if (libroEntity != null){
            libroEntity.setTitulo(libroRequest.getTitulo());
            libroEntity.setEditor(libroRequest.getEditor());
            return libroDAO.save(libroEntity);
        }
        return null;
    }

    @Override
    public LibroEntity eliminarLibro(Long id)throws Exception {
         libroDAO.delete(obtenerLibrorPorId(id));
         return null;
    }
}

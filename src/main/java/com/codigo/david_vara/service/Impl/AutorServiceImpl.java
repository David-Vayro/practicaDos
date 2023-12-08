package com.codigo.david_vara.service.Impl;

import com.codigo.david_vara.dao.AutorDAO;
import com.codigo.david_vara.entity.AutorEntity;
import com.codigo.david_vara.request.AutorRequest;
import com.codigo.david_vara.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {
    @Autowired
    private AutorDAO autorDAO;

    @Override
    public List<AutorEntity> obtenerTodos() {

        return autorDAO.findAll();
    }

    @Override
    public AutorEntity obtenerAutorPorId(Long id) throws Exception {
        Optional<AutorEntity> autor = autorDAO.findById(id);
        if (autor.isPresent()){
            return autor.get();
        }
        return null;
    }

    @Override
    public AutorEntity crearAutor(AutorEntity autor) {
        autorDAO.save(autor);
        return autor;
    }

    @Override
    public AutorEntity actualizarAutor(Long id, AutorRequest autorRequest) throws Exception {
        AutorEntity autorEntity = obtenerAutorPorId(id);
        if(autorEntity!=null){
            autorEntity.setNombre(autorRequest.getNombre());
            return autorDAO.save(autorEntity);
        }
        return null;
    }

    @Override
    public AutorEntity  eliminarAutor(Long id) throws Exception {
     autorDAO.delete(obtenerAutorPorId(id));
     return null;
    }
}

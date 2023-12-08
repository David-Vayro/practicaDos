package com.codigo.david_vara.service.Impl;

import com.codigo.david_vara.dao.CategoriaDAO;
import com.codigo.david_vara.entity.CategoriaEntity;
import com.codigo.david_vara.request.CategoriaRequest;
import com.codigo.david_vara.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
@Autowired
private CategoriaDAO categoriaDAO;
    @Override
    public List<CategoriaEntity> obtenerTodos() {
        return categoriaDAO.findAll();
    }

    @Override
    public CategoriaEntity obtenerCategoriaPorId(Long id) throws Exception {
        Optional<CategoriaEntity> categoria = categoriaDAO.findById(id);
        if (categoria.isPresent()){
            return categoria.get();
        }
        return null;
    }

    @Override
    public CategoriaEntity crearCategoria(CategoriaEntity categoria) {
        return categoriaDAO.save(categoria);
    }

    @Override
    public CategoriaEntity actualizarCategoria(Long id, CategoriaRequest categoriaRequest)  throws Exception{
        CategoriaEntity categoriaEntity = obtenerCategoriaPorId(id);
        if (categoriaEntity!=null){
            categoriaEntity.setNombre(categoriaRequest.getNombre());
            return categoriaDAO.save(categoriaEntity);
        }
        return null;
    }

    @Override
    public CategoriaEntity eliminarCategoria(Long id) throws Exception{
        categoriaDAO.delete(obtenerCategoriaPorId(id));
        return null;
    }
}

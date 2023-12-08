package com.codigo.david_vara.service.Impl;

import com.codigo.david_vara.dao.EditorDAO;
import com.codigo.david_vara.entity.EditorEntity;
import com.codigo.david_vara.request.EditorRequest;
import com.codigo.david_vara.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorServiceImpl implements EditorService {
    @Autowired
    private EditorDAO editorDAO;
    @Override
    public List<EditorEntity> obtenerTodos() {
        return editorDAO.findAll();
    }

    @Override
    public EditorEntity obtenerEditorPorId(Long id) throws Exception {
        Optional<EditorEntity> editor = editorDAO.findById(id);
        if (editor.isPresent()){
            return editor.get();
        }
        return null;
    }

    @Override
    public EditorEntity crearEditor(EditorEntity editor) {
        return editorDAO.save(editor);
    }

    @Override
    public EditorEntity actualizarEditor(Long id, EditorRequest editorRequest)throws Exception {
        EditorEntity editorEntity = obtenerEditorPorId(id);
        if (editorEntity!=null){
            editorEntity.setNombre(editorRequest.getNombre());
            return editorDAO.save(editorEntity);
        }
        return null;
    }

    @Override
    public EditorEntity eliminarEditor(Long id) throws Exception{
        editorDAO.delete(obtenerEditorPorId(id));
        return null;
    }
}

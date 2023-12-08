package com.codigo.david_vara.service;

import com.codigo.david_vara.entity.CategoriaEntity;
import com.codigo.david_vara.entity.EditorEntity;
import com.codigo.david_vara.request.EditorRequest;

import java.util.List;

public interface EditorService {
    List<EditorEntity> obtenerTodos();
    EditorEntity obtenerEditorPorId(Long id) throws Exception;
    EditorEntity crearEditor(EditorEntity editor);
    EditorEntity actualizarEditor(Long id, EditorRequest editorRequest) throws Exception;
    EditorEntity eliminarEditor(Long id) throws Exception;
}

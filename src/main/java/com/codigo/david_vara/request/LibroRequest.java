package com.codigo.david_vara.request;

import com.codigo.david_vara.entity.EditorEntity;

public class LibroRequest {
    private String titulo;
    private EditorEntity editor;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public EditorEntity getEditor() {
        return editor;
    }

    public void setEditor(EditorEntity editor) {
        this.editor = editor;
    }
}

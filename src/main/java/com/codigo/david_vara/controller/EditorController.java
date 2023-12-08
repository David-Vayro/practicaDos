package com.codigo.david_vara.controller;


import com.codigo.david_vara.entity.EditorEntity;
import com.codigo.david_vara.request.EditorRequest;
import com.codigo.david_vara.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class EditorController {
    @Autowired
    private EditorService editorService;
    @GetMapping("/api/v1/editores")
    public List<EditorEntity> listarEditores() {
        List<EditorEntity> editores = editorService.obtenerTodos();
        return editores;
    }
    @GetMapping("/api/v1/editor/{id}")
    public ResponseEntity<EditorEntity> obtenerEditorPorId(@PathVariable Long id) throws Exception{
        EditorEntity editor = editorService.obtenerEditorPorId(id);
        return ResponseEntity.ok(editor);
    }

    @PostMapping("/api/v1/editor")
    public ResponseEntity<EditorEntity> crearEditor(@RequestBody EditorEntity editor) {
        EditorEntity nuevoEditor = editorService.crearEditor(editor);
        return new ResponseEntity<>(nuevoEditor, HttpStatus.CREATED);
    }
    @PutMapping("/api/v1/editor/{id}")
    public EditorEntity actualizarEditor(@PathVariable Long id, @RequestBody EditorRequest editorRequest) throws Exception {
        return editorService.actualizarEditor(id, editorRequest);
    }
    @DeleteMapping("/api/v1/editor/{id}")
    private ResponseEntity<Void> eliminarEditor(@PathVariable Long id) throws Exception {
        editorService.eliminarEditor(id);
        return ResponseEntity.ok().build();
    }
}

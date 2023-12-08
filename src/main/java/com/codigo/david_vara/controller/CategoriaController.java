package com.codigo.david_vara.controller;


import com.codigo.david_vara.entity.CategoriaEntity;
import com.codigo.david_vara.request.CategoriaRequest;
import com.codigo.david_vara.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("/api/v1/categorias")
    public List<CategoriaEntity> listarCategorias() {
        List<CategoriaEntity> categorias = categoriaService.obtenerTodos();
        return categorias;
    }
    @GetMapping("/api/v1/categoria/{id}")
    public ResponseEntity<CategoriaEntity> obtenerCategoriaPorId(@PathVariable Long id) throws Exception{
        CategoriaEntity categoria = categoriaService.obtenerCategoriaPorId(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping("/api/v1/categoria")
    public ResponseEntity<CategoriaEntity> crearCategoria(@RequestBody CategoriaEntity categoria) {
        CategoriaEntity nuevaCategoria = categoriaService.crearCategoria(categoria);
        return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
    }
    @PutMapping("/api/v1/categoria/{id}")
    public CategoriaEntity actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaRequest categoriaRequest) throws Exception {
        return categoriaService.actualizarCategoria(id, categoriaRequest);
    }
    @DeleteMapping("/api/v1/categoria/{id}")
    private ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) throws Exception {
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.ok().build();
    }
}

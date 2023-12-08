package com.codigo.david_vara.controller;


import com.codigo.david_vara.entity.LibroEntity;
import com.codigo.david_vara.request.LibroRequest;
import com.codigo.david_vara.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class LibroController {
    @Autowired
  private   LibroService libroService;
    @GetMapping("/api/v1/libros")
    public List<LibroEntity> listarLibros() {
        List<LibroEntity> libros = libroService.obtenerTodos();
        return libros;
    }
    @GetMapping("/api/v1/libro/{id}")
    public ResponseEntity<LibroEntity> obtenerLibroPorId(@PathVariable Long id) throws Exception{
        LibroEntity autor = libroService.obtenerLibrorPorId(id);
        return ResponseEntity.ok(autor);
    }

    @PostMapping("/api/v1/libro")
    public ResponseEntity<LibroEntity> crearLibro(@RequestBody LibroEntity libro) {
        LibroEntity nuevoAutor = libroService.crearLibro(libro);
        return new ResponseEntity<>(nuevoAutor, HttpStatus.CREATED);
    }
    @PutMapping("/api/v1/libro/{id}")
    public LibroEntity actualizarLibro(@PathVariable Long id, @RequestBody LibroRequest libroRequest) throws Exception {
        return libroService.actualizarLibro(id, libroRequest);
    }
    @DeleteMapping("/api/v1/libro/{id}")
    private ResponseEntity<Void> eliminarLibro(@PathVariable Long id) throws Exception {
        libroService.eliminarLibro(id);
        return ResponseEntity.ok().build();
    }
}

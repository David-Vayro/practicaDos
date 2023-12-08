package com.codigo.david_vara.controller;

import com.codigo.david_vara.entity.AutorEntity;
import com.codigo.david_vara.request.AutorRequest;
import com.codigo.david_vara.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AutorController {
   @Autowired
    private AutorService autorService;
   @GetMapping("/api/v1/autores")
public List<AutorEntity> listarAutores() {
    List<AutorEntity> autores = autorService.obtenerTodos();
    return autores;
}
@GetMapping("/api/v1/autor/{id}")
public ResponseEntity<AutorEntity> obtenerAutorPorId(@PathVariable Long id) throws Exception{
       AutorEntity autor = autorService.obtenerAutorPorId(id);
       return ResponseEntity.ok(autor);
}

    @PostMapping("/api/v1/autor")
    public ResponseEntity<AutorEntity> crearAutor(@RequestBody AutorEntity autor) {
        AutorEntity nuevoAutor = autorService.crearAutor(autor);
        return new ResponseEntity<>(nuevoAutor, HttpStatus.CREATED);
    }
    @PutMapping("/api/v1/autor/{id}")
    public AutorEntity actualizarAutor(@PathVariable Long id, @RequestBody AutorRequest autorRequest) throws Exception {
        return autorService.actualizarAutor(id, autorRequest);
    }
    @DeleteMapping("/api/v1/autor/{id}")
    private ResponseEntity<Void> eliminarAutor(@PathVariable Long id) throws Exception {
       autorService.eliminarAutor(id);
       return ResponseEntity.ok().build();
    }
}

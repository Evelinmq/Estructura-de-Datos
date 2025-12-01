package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.LibroRequest;
import com.example.demo.dto.ErrorResponse;
import com.example.demo.service.LibroService;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    LibroService service;

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarLibro(@RequestBody LibroRequest request) {

        if (request.getTitulo() == null || request.getTitulo().isBlank()) {
            ErrorResponse error = new ErrorResponse();
            error.setError("Datos incorrectos");
            error.setDetail("El campo 'titulo' es obligatorio");
            return ResponseEntity.badRequest().body(error);
        }

        if (request.getAutor() == null || request.getAutor().isBlank()) {
            ErrorResponse error = new ErrorResponse();
            error.setError("Datos incorrectos");
            error.setDetail("El campo 'autor' es obligatorio");
            return ResponseEntity.badRequest().body(error);
        }

        return ResponseEntity.ok(service.agregarLibro(request));
    }

    @GetMapping("/lista")
    public ResponseEntity<?> obtenerLibros() {
        return ResponseEntity.ok(service.obtenerLibros());
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarLibro() {
        return ResponseEntity.ok(service.eliminarLibro());
    }
}

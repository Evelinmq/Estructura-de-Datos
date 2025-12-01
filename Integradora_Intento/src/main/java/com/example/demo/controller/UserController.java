package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.ErrorResponse;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarUsuario(@RequestBody UserRequest request) {

        if (request.getNombre() == null || request.getNombre().isBlank()) {
            ErrorResponse error = new ErrorResponse();
            error.setError("Error en la entrada de datos");
            error.setDetail("El campo 'nombre' no puede estar vacío");
            return ResponseEntity.badRequest().body(error);
        }

        return ResponseEntity.ok(service.agregarUsuario(request));
    }

    @GetMapping("/lista")
    public ResponseEntity<?> obtenerUsuarios() {
        return ResponseEntity.ok(service.obtenerUsuarios());
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarUsuario() {
        return ResponseEntity.ok(service.eliminarUsuario());
    }
}


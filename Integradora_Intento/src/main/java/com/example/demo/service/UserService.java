package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.structure.ArrayStack;

@Service
public class UserService {

    private Map<Integer, String> users = new HashMap<>();
    private ArrayStack<String> history = new ArrayStack<>();

    public String agregarUsuario(UserRequest r) {
        users.put(r.getId(), r.getNombre());
        history.push("USER_CREATED:" + r.getId());
        return "Usuario agregado correctamente";
    }

    public Map<Integer, String> obtenerUsuarios() {
        return users;
    }

    public String eliminarUsuario() {
        return "Función eliminar usuario aún no implementada";
    }
}

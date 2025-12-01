package mx.edu.utez.integradora.service;

import org.springframework.stereotype.Service;

import mx.edu.utez.integradora.model.User;
import mx.edu.utez.integradora.structure.UserLinkedList;

@Service
public class UserService {
    private final UserLinkedList users = new UserLinkedList();

    // Crear usuario
    public User create(User user) {
        user.setActive(true);
        users.add(user);
        return user;
    }

    // Listar todos los usuarios
    public User[] getAll() {
        return users.toArray();
    }

    // Buscar por ID
    public User getById(int id) {
        return users.findById(id);
    }
}

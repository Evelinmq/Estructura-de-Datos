package mx.edu.utez.integradora.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import mx.edu.utez.integradora.model.User;
import mx.edu.utez.integradora.structure.UserLinkedList;

@Service
public class UserService {
    private final UserLinkedList users = new UserLinkedList();
    private int nextId = 1;


    @PostConstruct
    public void init() {
        create(new User(0, "James", true));
        create(new User(0, "Victoria", true));
        create(new User(0, "Charlie", true));

        System.out.println(">>> Usuarios precargados");
    }

    // Crear usuario
    public User create(User user) {
        user.setId(nextId++);
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

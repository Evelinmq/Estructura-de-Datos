package mx.edu.utez.integradora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.integradora.dto.ErrorResponse;
import mx.edu.utez.integradora.model.Book;
import mx.edu.utez.integradora.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    // Crear libro
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Book request) {

        ErrorResponse error = new ErrorResponse();

        if (request.getId() <= 0) {
            return error("ID inválido", "El id debe ser mayor a 0");
        }
        if (request.getTitle() == null || request.getTitle().isBlank()) {
            return error("Título inválido", "El título no puede estar vacío");
        }
        if (request.getAvaliableCopies() < 0) {
            return error("Copias inválidas", "Las copias disponibles deben ser >= 0");
        }

        Book created = service.create(request);
        return ResponseEntity.ok(created);
    }

    // Obtener todos los libros
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // Obtener libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Book book = service.getById(id);

        if (book == null) {
            return error("Libro no encontrado", "No existe un libro con id " + id);
        }

        return ResponseEntity.ok(book);
    }

    // Actualizar libro completo
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Book request) {

        Book updated = service.update(id, request);

        if (updated == null) {
            return error("Libro no encontrado", "No existe un libro con id " + id);
        }

        return ResponseEntity.ok(updated);
    }

    // Baja lógica del libro / cambio de estatus
    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable int id, @RequestParam boolean active) {

        boolean updated = service.updateStatus(id, active);

        if (!updated) {
            return error("Libro no encontrado", "No existe un libro con id " + id);
        }

        return ResponseEntity.ok("Estatus actualizado");
    }

    // Buscar por título (query param)
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String title) {

        if (title == null || title.isBlank()) {
            return error("Dato inválido", "Debe ingresar un título para buscar");
        }

        return ResponseEntity.ok(service.searchByTitle(title));
    }

    // Metodo auxiliar para errores
    private ResponseEntity<ErrorResponse> error(String err, String detail) {
        ErrorResponse e = new ErrorResponse();
        e.setError(err);
        e.setDetail(detail);
        return ResponseEntity.badRequest().body(e);
    }
}

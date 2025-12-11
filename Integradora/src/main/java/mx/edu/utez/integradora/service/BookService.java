package mx.edu.utez.integradora.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import mx.edu.utez.integradora.dto.ErrorResponse;
import mx.edu.utez.integradora.model.Book;
import mx.edu.utez.integradora.structure.ArrayQueue;
import mx.edu.utez.integradora.structure.BookLinkedList;

@Service
public class BookService {
    private final BookLinkedList books = new BookLinkedList();
    private static final int MAX_WAITLIST = 50;

    @PostConstruct
    public void init() {
        Book b1 = new Book(1, "El Principito", "Antoine de Saint-Exupéry", 10);
        b1.setWaitlist(new ArrayQueue<>());
        books.add(b1);

        Book b2 = new Book(2, "Cien años de soledad", "Gabriel García Márquez", 7);
        b2.setWaitlist(new ArrayQueue<>());
        books.add(b2);

        Book b3 = new Book(3, "Fahrenheit 451", "Ray Bradbury", 3);
        b3.setWaitlist(new ArrayQueue<>());
        books.add(b3);

        Book b4 = new Book(4, "Una corte de niebla y furia", "Sarah J: Maaas", 1);
        b4.setWaitlist(new ArrayQueue<>());
        books.add(b4);

        System.out.println(">>> Libros precargados en LinkedList.");
    }


    // Registrar libro
    public Book create(Book book) {

        // Crear waitlist si viene null
        if (book.getWaitlist() == null) {
            book.setWaitlist(new ArrayQueue<>());
        }

        // Activar libro por defecto
        book.setActive(true);

        books.add(book);
        return book;
    }

    // Obtener catálogo
    public Book[] getAll() {
        return books.toArray();
    }

    // Buscar por ID
    public Book getById(int id) {
        return books.findById(id);
    }

    // Actualizar libro
    public Book update(int id, Book data) {
        Book existing = books.findById(id);
        if (existing == null) return null;

        if (data.getTitle() != null) existing.setTitle(data.getTitle());
        if (data.getAuthor() != null) existing.setAuthor(data.getAuthor());
        if (data.getAvaliableCopies() >= 0) 
            existing.setAvaliableCopies(data.getAvaliableCopies());

        return existing;
    }

    // Cambiar status
    public boolean updateStatus(int id, boolean status) {
        Book book = books.findById(id);
        if (book == null) return false;

        book.setActive(status);
        return true;
    }

    // Buscar por título
    public Book[] searchByTitle(String title) {
        return books.searchByTitle(title);
    }

    // Añadir una persona a la waitlist
    public Object joinWaitlist(int idBook, String personName) {

        Book book = books.findById(idBook);

        if (book == null) {
            ErrorResponse error = new ErrorResponse();
            error.setError("No encontrado");
            error.setDetail("No existe un libro con el ID " + idBook);
            return error;
        }

        if (book.getWaitlist() == null) {
            book.setWaitlist(new ArrayQueue<>());
        }

        ArrayQueue<String> queue = book.getWaitlist();

        // Validar límite de la lista de espera
        if (queue.getSize() >= MAX_WAITLIST) {
            ErrorResponse error = new ErrorResponse();
            error.setError("Lista de espera llena");
            error.setDetail("La lista de espera ha llegado a su límite de " + MAX_WAITLIST);
            return error;
        }

        queue.offer(personName);

        return "Agregado a la lista de espera";
    }
}

package mx.edu.utez.integradora.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.integradora.model.Book;
import mx.edu.utez.integradora.service.BookService;
import mx.edu.utez.integradora.structure.ArrayQueue;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final BookService bookService;

    public ReservationController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/{id}")
    public ArrayQueue<Integer> getWaitlist(@PathVariable int id) {
        Book book = bookService.getById(id);
        return book.getWaitlist();
    }

    @DeleteMapping
    public boolean delete(@RequestParam int userId, @RequestParam int bookId) {
        Book book = bookService.getById(bookId);
        return book.getWaitlist().remove(userId);
    }
}

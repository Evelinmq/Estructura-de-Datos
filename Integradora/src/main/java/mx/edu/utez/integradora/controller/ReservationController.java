package mx.edu.utez.integradora.controller;

import mx.edu.utez.integradora.service.ReservationService;
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
    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    // Obtener reservas por libro
    @GetMapping("/book/{bookId}")
    public String[] getReservations(@PathVariable int bookId) {
        return service.getReservationsByBook(bookId);
    }

    // Consultar posición
    @GetMapping("/position")
    public int getPosition(@RequestParam int userId, @RequestParam int bookId) {
        return service.getUserPosition(userId, bookId);
    }

    // Cancelar reserva
    @DeleteMapping
    public boolean cancel(@RequestParam int userId, @RequestParam int bookId) {
        return service.cancelReservation(userId, bookId);
    }
}

package mx.edu.utez.integradora.service;

import mx.edu.utez.integradora.model.Book;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final BookService bookService;

    public ReservationService(BookService bookService) {
        this.bookService = bookService;
    }

    // Obtener lista de espera completa por libro
    public String[] getReservationsByBook(int bookId) {
        Book book = bookService.getById(bookId);
        if (book == null) return null;

        String[] arr = book.getWaitlist().toArray();

        return arr;
    }

    // Consultar posición del usuario
    public int getUserPosition(int userId, int bookId) {
        Book book = bookService.getById(bookId);
        if (book == null) return -1;

        String target = String.valueOf(userId);

        String[] arr = book.getWaitlist().toArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i + 1; // posiciones empiezan en 1
            }
        }
        return -1;
    }

    // Cancelar reserva
    public boolean cancelReservation(int userId, int bookId) {
        Book book = bookService.getById(bookId);
        if (book == null) return false;

        String target = String.valueOf(userId);

        String[] arr = book.getWaitlist().toArray();

        // reconstruir cola sin el user
        book.getWaitlist().clear();

        boolean removed = false;

        for (String u : arr) {
            if (u.equals(target)) {
                removed = true;  // no volver a añadirlo
            } else {
                book.getWaitlist().offer(u);
            }
        }

        return removed;
    }
}

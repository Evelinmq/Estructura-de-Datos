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

        //String[] arr = book.getWaitlist().toArray();

        Object[] temp = book.getWaitlist().toArray();
        String[] arr = new String[temp.length];

        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i].toString();
        }


        return arr;

    }

    // Consultar posición del usuario
    public int getUserPosition(int userId, int bookId) {
        Book book = bookService.getById(bookId);
        if (book == null) return -1;

        String target = String.valueOf(userId);

        Object[] temp = book.getWaitlist().toArray();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].toString().equals(target)) {
                return i + 1;
            }
        }

        return -1;
    }

    // Cancelar reserva
    public boolean cancelReservation(int userId, int bookId) {
        Book book = bookService.getById(bookId);
        if (book == null) return false;

        String target = String.valueOf(userId);

        Object[] temp = book.getWaitlist().toArray();
        book.getWaitlist().clear();

        boolean removed = false;

        for (Object o : temp) {
            String u = o.toString();
            if (u.equals(target)) {
                removed = true;  // no lo añadimos
            } else {
                book.getWaitlist().offer(u);
            }
        }

        return removed;
    }
}

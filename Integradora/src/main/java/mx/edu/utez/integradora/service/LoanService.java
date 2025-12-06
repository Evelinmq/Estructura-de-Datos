package mx.edu.utez.integradora.service;

import org.springframework.stereotype.Service;

import mx.edu.utez.integradora.model.Book;
import mx.edu.utez.integradora.model.HistoryAction;
import mx.edu.utez.integradora.model.Loan;
import mx.edu.utez.integradora.structure.ArrayStack;
import mx.edu.utez.integradora.structure.LoanLinkedList;

@Service
public class LoanService {
    private final LoanLinkedList loans = new LoanLinkedList();
    private final ArrayStack<HistoryAction> history = new ArrayStack<>();

    private final BookService bookService;
    private final LoanLinkedList loan = new LoanLinkedList();


    public LoanService(BookService bookService) {
        this.bookService = bookService;
    }

    public Loan[] getLoans() {
        return (Loan[]) loan.toArray();
    }

    // Eliminar préstamo por id (usado por HistoryService - undo)
    public boolean removeLoan(int id) {
        return loan.remove(id);
    }



    // Crear préstamo (Flujo B)
    public Loan createLoan(int userId, int bookId) {
        Book book = bookService.getById(bookId);
        if (book == null) return null;

        // Caso 1: hay copias disponibles
        if (book.getAvaliableCopies() > 0) {

            int newId = loans.size() + 1;

            Loan loan = new Loan(newId, userId, bookId, false);
            loans.add(loan);

            book.setAvaliableCopies(book.getAvaliableCopies() - 1);

            //Registrar en el historisl
            history.push(new HistoryAction(
                HistoryAction.Type.CREATE_LOAN,
                    loan,
                    userId,
                    bookId
            ));

            return loan;
        }

        // Caso 2: NO hay copias, se agrega al waitlist (lista de espera)
        book.getWaitlist().offer(String.valueOf(userId));

        //Registra en waitlist
        history.push(new HistoryAction(
            HistoryAction.Type.ADD_TO_WAITLIST,
                null,
                userId,
                bookId
        ));

        return null;
    }

    // Devolución de libros (Flujo C)
    public boolean returnLoan(int loanId) {
        Loan loan = findById(loanId);
        if (loan == null || loan.isReturned()) return false;

        loan.setReturned(true);

        Book book = bookService.getById(loan.getBookId());

        // Registrar en historial
        history.push(new HistoryAction(
            HistoryAction.Type.RETURN_LOAN,
                loan,
                loan.getUserId(),
                loan.getBookId()
        ));

        // Revisar waitlist para dr libros a personas en la queue
        if (!book.getWaitlist().isEmpty()) {
            String nextUserStr = book.getWaitlist().poll();
            int nextUser = Integer.parseInt(nextUserStr);

            createLoan(nextUser, book.getId());

        } else {
            // Si nadie esta en la lista de espera, devolver la copia
            book.setAvaliableCopies(book.getAvaliableCopies() + 1);
        }

        return true;
    }


    //Búsqueda de préstamo por ID
    public Loan findById(int id) {
        Object[] arr = loans.toArray();
        for (Object o : arr) {
            Loan l = (Loan) o;
            if (l.getId() == id) return l;
        }
        return null;
    }

    //Préstamos activos
    public Loan[] getActiveLoans() {
        LoanLinkedList list = new LoanLinkedList();

        for (Object o : loans.toArray()) {
            Loan l = (Loan) o;
            if (!l.isReturned()) {
                list.add(l);
            }
        }

        return (Loan[]) list.toArray();
    }

    //Obtener info de préstamos por usuario
    public Loan[] getLoansByUser(int userId) {
        LoanLinkedList list = new LoanLinkedList();

        for (Object o : loans.toArray()) {
            Loan l = (Loan) o;
            if (l.getUserId() == userId) {
                list.add(l);
            }
        }

        return (Loan[]) list.toArray();
    }

    //Stack de historial
    public ArrayStack<HistoryAction> getHistoryStack() {
        return history;
    }
}

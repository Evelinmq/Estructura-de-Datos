package mx.edu.utez.integradora.service;

import org.springframework.stereotype.Service;

import mx.edu.utez.integradora.model.Book;
import mx.edu.utez.integradora.model.HistoryAction;
import mx.edu.utez.integradora.model.Loan;
import mx.edu.utez.integradora.structure.ArrayStack;
import mx.edu.utez.integradora.structure.SinglyLinkedList;

@Service
public class LoanService {
    private final SinglyLinkedList loans = new SinglyLinkedList();
    private final ArrayStack<HistoryAction> history = new ArrayStack<>();

    private final BookService bookService;

    public LoanService(BookService bookService) {
        this.bookService = bookService;
    }

    // Crear préstamo (Flujo B)
    public Loan createLoan(int userId, int bookId) {
        Book book = bookService.getById(bookId);
        if (book == null) return null;

        // Caso A: hay copias
        if (book.getAvaliableCopies() > 0) {

            int newId = loans.size() + 1;

            Loan loan = new Loan(newId, userId, bookId);
            loans.add(loan);

            book.setAvaliableCopies(book.getAvaliableCopies() - 1);

            history.push(new HistoryAction(
                HistoryAction.Type.CREATE_LOAN, loan, userId, bookId
            ));

            return loan;
        }

        // Caso B: NO hay copias → agregar al waitlist
        book.getWaitlist().enqueue(userId);

        history.push(new HistoryAction(
            HistoryAction.Type.ADD_TO_WAITLIST, null, userId, bookId
        ));

        return null;
    }

    // Devolución (Flujo C)
    public boolean returnLoan(int loanId) {
        Loan loan = findById(loanId);
        if (loan == null || loan.isReturned()) return false;

        loan.setReturned(true);
        Book book = bookService.getById(loan.getBookId());

        // Registrar en historial
        history.push(new HistoryAction(
            HistoryAction.Type.RETURN_LOAN, loan, loan.getUserId(), loan.getBookId()
        ));

        // Revisar waitlist
        if (!book.getWaitlist().isEmpty()) {
            int nextUser = book.getWaitlist().dequeue();
            createLoan(nextUser, book.getId());  // préstamo automático
        } else {
            book.setAvaliableCopies(book.getAvaliableCopies() + 1);
        }

        return true;
    }

    public Loan findById(int id) {
        Object[] array = loans.toArray();
        for (Object o : array) {
            Loan l = (Loan) o;
            if (l.getId() == id) return l;
        }
        return null;
    }

    public Loan[] getActiveLoans() {
        SinglyLinkedList list = new SinglyLinkedList();
        Object[] arr = loans.toArray();

        for (Object o : arr) {
            Loan l = (Loan) o;
            if (!l.isReturned()) list.add(l);
        }

        return (Loan[]) list.toArray();
    }

    public Loan[] getLoansByUser(int userId) {
        SinglyLinkedList list = new SinglyLinkedList();
        Object[] arr = loans.toArray();

        for (Object o : arr) {
            Loan l = (Loan) o;
            if (l.getUserId() == userId) list.add(l);
        }

        return (Loan[]) list.toArray();
    }

    public ArrayStack<HistoryAction> getHistoryStack() {
        return history;
    }
}

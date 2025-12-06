package mx.edu.utez.integradora.service;

import org.springframework.stereotype.Service;

import mx.edu.utez.integradora.model.Book;
import mx.edu.utez.integradora.model.HistoryAction;
import mx.edu.utez.integradora.model.Loan;
import mx.edu.utez.integradora.structure.ArrayStack;

@Service
public class HistoryService {
    private final LoanService loanService;
    private final BookService bookService;

    public HistoryService(LoanService loanService, BookService bookService) {
        this.loanService = loanService;
        this.bookService = bookService;
    }

    public boolean undo() {
        ArrayStack<HistoryAction> stack = loanService.getHistoryStack();
        if (stack.isEmpty()) return false;

        HistoryAction action = stack.pop();

        switch (action.getType()) {

            case CREATE_LOAN:
                // eliminar préstamo del sistema
                boolean removed = loanService.removeLoan(action.getLoan().getId());
                if (!removed) {
                    // o continuar
                    return false;
                }

                // regresar la copia al libro
                Book b1 = bookService.getById(action.getLoan().getBookId());
                if (b1 != null) {
                    b1.setAvaliableCopies(b1.getAvaliableCopies() + 1);
                }
                return true;

            case RETURN_LOAN:
                // restaurar préstamo
                Loan loan = action.getLoan();
                loan.setReturned(false);

                Book b2 = bookService.getById(loan.getBookId());
                b2.setAvaliableCopies(b2.getAvaliableCopies() - 1);
                return true;

            case ADD_TO_WAITLIST:
                Book b3 = bookService.getById(action.getBookId());
                b3.getWaitlist().poll(); // quitar último agregado
                return true;
        }

        return false;
    }
}

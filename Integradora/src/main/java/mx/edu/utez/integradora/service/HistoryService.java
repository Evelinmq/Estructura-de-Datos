package mx.edu.utez.integradora.service;

import org.springframework.stereotype.Service;

import mx.edu.utez.integradora.model.Book;
import mx.edu.utez.integradora.model.HistoryAction;
import mx.edu.utez.integradora.model.Loan;
import mx.edu.utez.integradora.structure.ArrayStack;

@Service
public class HistoryService {
    /*private ArrayStack<String> stack = new ArrayStack<>();

    public void log(String action) {
        stack.push(action);
    }

    public String undo() {
        Object last = stack.pop();
        if (last == null) return "No hay acciones para deshacer";

        return "Deshacer acción: " + last;
    }

    public ArrayStack<String> getHistory() {
        return stack;
    }*/

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
                Loan loan = action.getLoan();
                loan.setReturned(true);
                Book b1 = bookService.getById(loan.getBookId());
                b1.setAvaliableCopies(b1.getAvaliableCopies() + 1);
                return true;

            case RETURN_LOAN:
                Loan l = action.getLoan();
                l.setReturned(false);
                Book b2 = bookService.getById(l.getBookId());
                b2.setAvaliableCopies(b2.getAvaliableCopies() - 1);
                return true;

            case ADD_TO_WAITLIST:
                Book b3 = bookService.getById(action.getBookId());
                b3.getWaitlist().remove(action.getUserId());
                return true;
        }

        return false;
    }
}

package mx.edu.utez.integradora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryAction {
    public enum Type {
        CREATE_LOAN,
        RETURN_LOAN,
        ADD_TO_WAITLIST
    }

    private Type type;
    private Loan loan;
    private int userId;
    private int bookId;
}

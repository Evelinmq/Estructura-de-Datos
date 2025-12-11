package mx.edu.utez.integradora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    private int id;
    private int userId;
    private int bookId;
    private boolean returned = false;

    public boolean isReturned() { 
        return returned; 
    }

    public void setReturned(boolean returned) { 
        this.returned = returned; 
    }
}

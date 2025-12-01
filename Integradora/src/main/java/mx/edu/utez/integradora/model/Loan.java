package mx.edu.utez.integradora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    int id;
    int userId;
    int bookId;
    boolean returned = false;

    public boolean isReturned() { 
        return returned; 
    }

    public void setReturned(boolean returned) { 
        this.returned = returned; 
    }
}

package mx.edu.utez.integradora.structure;

import mx.edu.utez.integradora.model.Loan;

public class LoanNode {

    Loan data;
    LoanNode next;
    LoanNode prev;

    public LoanNode(Loan data) {
        this.data = data;
        this.next = null;
    }

}

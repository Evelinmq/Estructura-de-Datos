package mx.edu.utez.integradora.structure;

import mx.edu.utez.integradora.model.Loan;

public class LoanLinkedList {

    private LoanNode head;
    private int size;

    public LoanLinkedList() {
        this.head = null;
    }

    //Agregar préstamo
    public void add(Loan loan) {
        LoanNode newNode = new LoanNode(loan);

        if (head == null) {
            head = newNode;
        } else {
            LoanNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public Loan[] toArray() {
        Loan[] arr = new Loan[size];
        LoanNode curr = head;
        int i = 0;

        while (curr != null) {
            arr[i++] = curr.data;
            curr = curr.next;
        }
        return arr;
    }


    // Buscar por ID
    public Loan findById(int id) {
        LoanNode current = head;

        while (current != null) {
            if (current.data.getId() == id) {
                return current.data;
            }
            current = current.next;
        }

        return null;
    }

    // Lista de préstamos activos
    public Loan[] getActive() {
        int count = 0;
        LoanNode current = head;

        while (current != null) {
            if (!current.data.isReturned()) {
                count++;
            }
            current = current.next;
        }

        Loan[] result = new Loan[count];
        current = head;

        int i = 0;
        while (current != null) {
            if (!current.data.isReturned()) {
                result[i++] = current.data;
            }
            current = current.next;
        }

        return result;
    }

    // Buscar por usuario
    public Loan[] findByUser(int userId) {
        int count = 0;
        LoanNode current = head;

        while (current != null) {
            if (current.data.getUserId() == userId) {
                count++;
            }
            current = current.next;
        }

        Loan[] result = new Loan[count];
        current = head;
        int i = 0;

        while (current != null) {
            if (current.data.getUserId() == userId) {
                result[i++] = current.data;
            }
            current = current.next;
        }

        return result;
    }

    // Eliminar préstamo por ID
    public boolean remove(int id) {
        if (head == null) return false;

        if (head.data.getId() == id) {
            head = head.next;
            return true;
        }

        LoanNode current = head;

        while (current.next != null && current.next.data.getId() != id) {
            current = current.next;
        }

        if (current.next == null) return false;

        current.next = current.next.next;
        return true;
    }

    public void printList(){
        LoanNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("null");
    }

}

package mx.edu.utez.integradora.structure;

import mx.edu.utez.integradora.model.Book;

public class BookNode {
    public Book data;
    public BookNode next;
    public BookNode prev;

    public BookNode(Book data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

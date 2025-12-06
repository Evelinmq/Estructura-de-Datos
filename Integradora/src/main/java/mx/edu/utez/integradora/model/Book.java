package mx.edu.utez.integradora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.integradora.structure.ArrayQueue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    int id;
    String title;
    String author;
    int avaliableCopies;
    boolean active;
    public ArrayQueue<String> waitlist;

    public Book(int id, String title, String author, int avaliableCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.avaliableCopies = avaliableCopies;
        this.active = true;                    // activado por defecto
        this.waitlist = new ArrayQueue<>();
    }

    public ArrayQueue<String> getWaitlist() { return waitlist; }
}

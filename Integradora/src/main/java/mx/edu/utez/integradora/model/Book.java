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
    public ArrayQueue<Integer> waitlist;
}

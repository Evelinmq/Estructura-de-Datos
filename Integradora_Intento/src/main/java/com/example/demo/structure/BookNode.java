package com.example.demo.structure;

import com.example.demo.model.Libro;

public class BookNode {
    public Libro data;
    public BookNode next;
    public BookNode prev;

    public BookNode(Libro data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}


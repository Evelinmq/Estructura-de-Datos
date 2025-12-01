package com.example.demo.model;

import com.example.demo.structure.ArrayQueue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    int id;
    String tiulo;
    String autor;
    int avaliableCopies;
    public ArrayQueue<Integer> waitlist;
}

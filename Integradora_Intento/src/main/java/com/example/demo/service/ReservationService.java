package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.structure.ArrayQueue;

@Service
public class ReservationService {

    // bookId → cola de usuarios
    private Map<Integer, ArrayQueue<Integer>> waitlists = new HashMap<>();

    public String addToWaitlist(int bookId, int userId) {

        waitlists.putIfAbsent(bookId, new ArrayQueue<>());

        waitlists.get(bookId).offer(userId);

        return "Usuario agregado a lista de espera del libro " + bookId;
    }

    public ArrayQueue<Integer> getWaitlist(int bookId) {
        return waitlists.get(bookId);
    }

    public String removeReservation(int bookId, int userId) {
        ArrayQueue<Integer> queue = waitlists.get(bookId);
        if (queue == null || queue.isEmpty()) return "La cola está vacía";

        // técnica: crear cola temporal y reconstruir
        ArrayQueue<Integer> temp = new ArrayQueue<>();
        boolean removed = false;

        while (!queue.isEmpty()) {
            int elem = (int) queue.poll();
            if (elem != userId) temp.offer(elem);
            else removed = true;
        }

        waitlists.put(bookId, temp);

        return removed
            ? "Reserva cancelada"
            : "El usuario no estaba en la cola";
    }
}

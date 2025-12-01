package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.structure.ArrayStack;

@Service
public class HistoryService {

    private ArrayStack<String> stack = new ArrayStack<>();

    public void log(String action) {
        stack.push(action);
    }

    public String undo() {
        Object last = stack.pop();
        if (last == null) return "No hay acciones para deshacer";

        return "Deshacer acción: " + last;
    }

    public ArrayStack<String> getHistory() {
        return stack;
    }
}

package mx.edu.utez.integradora.structure;

public interface IStack<T> {
//Decaración de sus métodos, pero no de sus bloques
    void push(T data);
    T pop();
    T peek();
    void clear();
    int size();
    boolean isEmpty();
    void print();
}

package com.example.demo.structure;

public class ArrayStack<T> implements IStack<T> {

    private Object[] data;
    private int top;
    //private static final int INITIAL = 10;
    
    //Constructor 1
    public ArrayStack() {
        this(10);  //Invoca al costructor 2
    }

    //Constructor 2
    public ArrayStack(int initialCapacity) {
        this.data = new Object[initialCapacity];
        this.top = 0;
    }

    @Override
    public void push(T element) {
        //Vamos a asegurar que aún tenga espacio el array
        data[top++] = (T) element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("La pila está vacía");
            return null;
        }
        T value = (T) data[--top];
        data[top] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        }
        return (T) data[top];
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
        /*
        Este es lo mismo que el return de arriba
        if(top == 0){
            return true;
        }
        return false;*/
    }

    @Override
    public void print() {

        //Es como si se hiciera un acumulador
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        //Recorre el arreglo al revés, es decir, desde la punta
        for (int i = top-1; i >= 0; i--) {
            sb.append(data[i]);
            if (i != 0) { 
                sb.append(" -> "); 
            }
        }

        sb.append("]");
        System.out.println(sb.toString());
    } 
}
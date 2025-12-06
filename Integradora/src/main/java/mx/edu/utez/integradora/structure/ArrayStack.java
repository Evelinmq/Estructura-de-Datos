package mx.edu.utez.integradora.structure;

import mx.edu.utez.integradora.model.HistoryAction;

public class ArrayStack<T> implements IStack<T> {

    private Object[] data;
    private int top;
    
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
        if (top == data.length) {
            expand();
        }
        data[top++] = element;
    }

    private void expand() {
        Object[] newArr = new Object[data.length * 2];
        System.arraycopy(data, 0, newArr, 0, data.length);
        data = newArr;
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
        return (T) data[top - 1];
    }

    @Override
    public void clear() {
        data = new Object[10];
        top = 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public void print() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(data[i] + " -> ");
        }
        System.out.println("null");

        /*
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
         */
    }

    public HistoryAction[] toArray() {
        HistoryAction[] arr = new HistoryAction[top];
        for (int i = 0; i < top; i++) {
            arr[i] = (HistoryAction) data[i];
        }
        return arr;
    } 
}

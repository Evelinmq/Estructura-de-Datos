package mx.edu.utez.integradora.structure;

public class ArrayQueue <T> implements IQueue<T>{

    private Object[] data;
    private int rear; //Indice de insercción
    private int front; //Indica el elemento al frente de la queue
    private int size; //Número de elementos en la queue
    private static final int INITIAL_CAPACITY = 10; //Constante par el tamaño inicial del array

    public ArrayQueue(){
        this.data = new Object[INITIAL_CAPACITY];
        this.rear = 0;
        this.front = 0;
        this.size = 0;
    }

    @Override
    public void offer(T element) {
        //Verificar la capacidad del array ()
        expandCapacity();
        data[rear] = element; //Pone el elemento en el índice asignado (rear)
        rear = (rear + 1) % data.length; //Recalcula rear pero evita que se desborde
        size++;
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            System.out.println("La Queue está vacía");
            return null;
        }
        T result = (T) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return result;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("La Queue está vacía");
            return null;
        }
        return (T) data[front];
    }

    @Override
    public void clear() {
        data = new Object[INITIAL_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    private void expandCapacity(){
        Object[] newArr = new Object[data.length*2]; //Creación de nuevo arreglo
        for (int i = 0; i < size; i++) {
            newArr[i] = data[(front + i) % data.length]; //Vaciado de la info empezando desde front
        }
        //Reiniciamos los valores del arreglo para poderlo seguir usando
        front = 0; //Pone el frente en la primera posición
        data = newArr; //Asignada el nuevo arreglo al atributo data
        rear = size; //Indice de la siguiente inserción
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[ (front + i) % data.length ]);
            if (i < size-1) {
                sb.append(" -> ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    public boolean remove(int userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
}

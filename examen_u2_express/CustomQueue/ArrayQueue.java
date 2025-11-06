package CustomQueue;

public class ArrayQueue<T> implements IQueue<T> {

    private Object[] data;
    private int rear;   // siguiente índice de inserción
    private int front;  // índice del frente
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public ArrayQueue() {
        this.data = new Object[INITIAL_CAPACITY];
        this.rear = 0;
        this.front = 0;
        this.size = 0;
    }

    /*
    @Override
    public void offer(T element) {
      
    }
    */


    @Override
    public void offer(T element) {
        //Verificar la capacidad del array ()
        if(size==data.length){
             expandCapacity();
        }
       
        data[rear]= element; //pone el elemento en el indice asignado (rear)
        rear= (rear+1) % data.length; //recalcula rear, pero evita que se desborde
        size++;
    } 

    // Inserción al FRENTE (necesario para UNDO )
    public void offerFront(T element) {
        if (size == data.length) {
            expandCapacity();
        }
        front = (front - 1 + data.length) % data.length;
        data[front] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T poll() {
        if (isEmpty()) {
            System.out.println("La Queue esta vacia");
            return null;
        }
        T result = (T) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return result;
    }


    

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("La queue esta vacia");
            return null;
        }
        return (T) data[front];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[(front + i) % data.length] = null;
        }
        front = 0;
        rear = 0;
        size = 0;
    }

    private void expandCapacity() {
        Object[] newArr = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = data[(front + i) % data.length];
        }
        front = 0;
        data = newArr;
        rear = size;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length]);
            if (i < size - 1) sb.append("->");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public int getSize() { return size; }
}

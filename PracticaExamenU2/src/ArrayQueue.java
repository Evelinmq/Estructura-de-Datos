public class ArrayQueue<T> implements IQueue<T> {

    private Object[] data;
    private int rear;  // Inserción
    private int front; // Peek
    private int size;  // Tamaño
    private static final int INITIAL_CAPACITY = 10;

    public ArrayQueue() {
        this.data = new Object[INITIAL_CAPACITY];
        this.rear = 0;
        this.front = 0;
        this.size = 0;
    }

    @Override
    public void offer(T element) {
        if (size==data.length) {
            expandCapacity();
        }
        data[rear] = element;
        rear = (rear + 1) % data.length;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
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
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            System.out.println("La Queue está vacía");
            return null;
        }
        return (T) data[front];
    }

    @Override
    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    private void expandCapacity() {
        if (size == data.length) {
            Object[] newArr = new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                newArr[i] = data[(front + i) % data.length];
            }
            data = newArr;
            front = 0;
            rear = size;
        }
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length]);
            if (i < size - 1) {
                sb.append(" -> ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    // Método para invertir
    public void reverse() {
        if (isEmpty()) return;

        Object[] stack = new Object[size];
        int top = -1;

        // Saca los elementos de la cola y los pone en el stack
        while (!isEmpty()) {
            stack[++top] = poll();
        }

        // Insertar en el stack
        while (top >= 0) {
            offer((T) stack[top--]);
        }
    }
}

package CustomStack;

public class ArrayStack<T> implements IStack<T> {
    private Object[] data;
    private int top;

    public ArrayStack() { this(10); }
    public ArrayStack(int initialCapacity) {
        this.data = new Object[initialCapacity];
        this.top = 0;
    }

    private void ensureCapacity(int need) {
        if (need <= data.length) return;
        int newCap = Math.max(data.length * 2, need);
        Object[] nd = new Object[newCap];
        for (int i = 0; i < top; i++) nd[i] = data[i];
        data = nd;
    }

    @Override
    public void push(T element) {
        ensureCapacity(top + 1);
        data[top++] = element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia");
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
            System.out.println("La pila esta vacia");
            return null;
        }
        return (T) data[top - 1];
    }

    @Override
    public void clear() {
        for (int i = 0; i < top; i++) data[i] = null;
        top = 0;
    }

    @Override public int size() { return top; }
    @Override public boolean isEmpty() { return top == 0; }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = top - 1; i >= 0; i--) {
            sb.append(data[i]);
            if (i != 0) sb.append("->");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}

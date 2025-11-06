public class ArrayStack<T> implements IStack<T> {

    private Object[] data;
    private int top; //El top vale cero 0


    //Constructor 1
    public ArrayStack(){
        this(10);//Aquí invoca al constructor 2

    }

    private void expandCapacity() {
        if (top == data.length) {
            Object[] newArr = new Object[data.length * 2];
            // copia los elementos en el nuevo arreglo
            System.arraycopy(data, 0, newArr, 0, top);
            data = newArr;
        }
    }

    //Constructor 2
    public ArrayStack(int initialCapacity){
        this.data = new Object[initialCapacity];
        this.top = 0;
    }

    @Override
    public void push(T element) {
        //Asegurarse de que el array tiene espacio 
        expandCapacity();
        data[top++] = (T) element;


    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("La pila está vacia");
            return null;
        }
        T value = (T) data[--top];
        data[top]=null;
        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if(isEmpty()){
            System.out.println("La pila está vacia");
            return null;
        }
        return (T) data[top -1];
    }

    @Override
    public void clear() {
        for (int i = 0; i < top; i++) {
            data[i] = null;
        }
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
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        for (int i = top-1; i >=0 ; i--) {
            sb.append(data[i]);
            if(i!=0) sb.append(" -> ");

        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }



}

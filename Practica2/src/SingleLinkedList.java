public class SingleLinkedList<T>{

    private Node<T> head;
    private Node<T> tail;
    public int size;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T removeLast() {
        if (head == null) {
            return null;
        }
        T dataRemove = tail.data;
         if (head == tail) {
             head = null;
             tail = null;
         }else {
             Node<T> current = head;
             while (current.next != tail) {
                 current = current.next;
             }
             current.next = null;
             tail = current;
         }
         size--;
         return dataRemove;
    }

    //Cración de un nuevo nodo
    public void add(int data){
        Node newNode = new Node(data); //Verificará que la lista se encuentra vacía
        if(head == null){
            head=newNode;
            return;
        }
        Node current=head;
        while(current.next !=null){
            current=current.next;
        }
        current.next=newNode; //Inserta el nuevo nodo

    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> current= head;
        while(current != null){
            sb.append(current.data);
            if(current.next != null)sb.append(" -> ");
            current=current.next;
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }

    public int size(){
        return size;
    }

}
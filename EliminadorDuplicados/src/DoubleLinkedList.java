public class DoubleLinkedList {

    Node head;
    Node tail;

    public void add(int data){
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void printForward(){
        Node current = head;

        if (current == null) {
            System.out.println("La lista está vacía");
            return;
        }
        
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

        System.out.println(current);
    }

    public void printBackward(){
        Node current = tail;

        if (current == null) {
            System.out.println("La lista está vacía");
            return;
        }


        while (current != null) { //Reversa
            System.out.println(current.data);
            current = current.prev;
        }
        System.out.println(current);
    }

    public boolean contains(int data){
        if(head == null){
            System.out.println("Tu lista está vacía");
            return false;
        }

        Node current = head;
        while (current != null) {
            if(current.data == data){
                return true; //Evitamos que se siga ejecutando
            }

            current = current.next;
        }
        
        return false;
    }

    
    public void removeDuplicates(){
        if(head == null){ //Pregunta si la lista está vacía
            System.out.println("Tu lista está vacía");
            return;
        }

        Node current = head;

        while (current != null) {
            Node checking = current.next;

            while (checking != null) {
                if(checking.data == current.data){
                    Node toDelete = checking;
                    checking = checking.next;

                    if(toDelete == tail){
                        tail = toDelete.prev;
                        tail.next = null;
                    }else{
                        toDelete.prev.next = toDelete.next;
                        toDelete.next.prev = toDelete.prev;
                    }
                }else{
                    checking = checking.next;
                }
            }
            current = current.next;
        }

        
    }
}
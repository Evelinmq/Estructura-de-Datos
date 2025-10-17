public class DoubleLinkedList {

    Node head;

    public void add(int data){
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;

        
    }

    public void printForward(){
        Node current = head;
        while (current != null) { //Pregunta si tiene referencia
            System.out.println(current.data); 
            current = current.next;
        }
        System.out.println(current);
    }

    public void printBackward(){
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        while (current != null) { //Reversa
            System.out.println(current.data);
            current = current.prev;
        }
        System.out.println(current);
    }

    public boolean contains(int data){
        /*if(head == null){
            System.out.println("Tu lista está vacía");
            return false;
        }
            Notifica al usuario
            */

        Node current = head;
        while (current != null) {
            if(current.data == data){
                return true; //Evitamos que se siga ejecutando
            }

            current = current.next;
        }
        
        return false;
    }

    
    public void remove(int data){
        if(head == null){ //Pregunta si la lista está vacía
            return;
        }
        

        if(head.data == data){ //Valida que el dato esté en el head
            head = head.next; //Elimina el primer nodo
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) { //Recorrer hasta encontrar el valor
            //Estándar de recorrido && pregunta si el valor es el que se busca

            current = current.next;
        }

        current.next = current.next.next; //Asignamos el nodo corriente al siguiente

    }
}

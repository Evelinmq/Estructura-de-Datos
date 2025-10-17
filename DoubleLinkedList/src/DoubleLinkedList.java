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

        //Node current = head;

        //while (current.next != null) {
          //  current = current.next;
        //}

        tail.next = newNode;
        //current.next = newNode;
        //newNode.prev = tail;
        newNode.prev = tail;
        tail = newNode;
        
    }

    public void printForward(){
        Node current = head;
        /*while (current != null) { //Pregunta si tiene referencia
            System.out.println(current.data); 
            current = current.next;
        }
        System.out.println(current);*/
        if (current == null) {
            System.out.println("La lista está vacía");
            return;
        }
        
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        //System.out.println(current);
        System.out.println();
    }

    public void printBackward(){
        //Node current = head;
        Node current = tail;

        if (current == null) {
            System.out.println("La lista está vacía");
            return;
        }
        
        /*while (current.next != null) {
            current = current.next;
        }*/

        while (current != null) { //Reversa
            System.out.println(current.data);
            current = current.prev;
        }
        //System.out.println(current);
        System.out.println();
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

    
    public void remove(int data){
        if(head == null){ //Pregunta si la lista está vacía
            System.out.println("Tu lista está vacía");
            return;
        }

        Node current = head;
        

        /*if(head.data == data){ //Valida que el dato esté en el head
            head = head.next; //Elimina el primer nodo
            return;
        }else{
            System.out.println("valor no encontrado");
        }*/

        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Valor no encontrado");
            return;
        }

        //Caso A: head
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }else{
                tail = null;
            }
            return;
        }

        //Caso B: medio
        current.prev.next = current.next;
        current.next.prev = current.prev;

        //Caso C: tail
        if (current == tail) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        /*while (current.next != null && current.next.data != data) { //Recorrer hasta encontrar el valor
            //Estándar de recorrido && pregunta si el valor es el que se busca

            current = current.next;
        }

        current.next = current.next.next; //Asignamos el nodo corriente al siguiente
        */
    }
}

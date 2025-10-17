public class SinglyLinkedList {

    Node head;

    public void add(int data){
        Node newNode =  new Node(data); //Creación de un nuevo ndo

        if(head == null){ //Verificación de la lista vacía
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) { //Recorrido de los nodos, hasta encontrar el último
            current = current.next;
        }

        current.next = newNode; //Inserta nuevo nodo al fina de la lista
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

    //Remover por valor
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

    public void printList(){
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("null");
    }

    public int countOccurrences(int data) {
    int count = 0;
    Node current = head;

    while (current != null) {
        if (current.data == data) {
            count++;
        }
        current = current.next;
    }

        return count;
    }


}



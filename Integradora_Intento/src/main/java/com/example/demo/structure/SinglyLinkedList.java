package com.example.demo.structure;

import com.example.demo.model.Libro;

public class SinglyLinkedList {

    private BookNode head;

    public SinglyLinkedList(){
        head = null;
    }

    public void add(Libro data){
        BookNode newNode =  new BookNode(data); //Creación de un nuevo ndo

        if(head == null){ //Verificación de la lista vacía
            head = newNode;
            //return;
        }else{
            BookNode current = head;
            while (current.next != null) { //Recorrido de los nodos, hasta encontrar el último
                current = current.next;
            }

            current.next = newNode; //Inserta nuevo nodo al fina de la lista
            newNode.prev = current;
        }
    }

    public Libro findById(int id) {
        BookNode current = head;
        while (current != null) {
            if (current.data.getId() == id) {
                return current.data;
            }
            current = current.next;
        }
        return null; // no encontrado
    }

    /*public boolean contains(int data){
        /*if(head == null){
            System.out.println("Tu lista está vacía");
            return false;
        }
            Notifica al usuario
            */

        BookNode current = head;
        while (current != null) {
            if(current.data == data){
                return true; //Evitamos que se siga ejecutando
            }

            current = current.next;
        }
        
        return false;
    }*/

    //Remover por valor
    public void removeById(int id){
        if(head == null){ //Pregunta si la lista está vacía
            return false;
        }

        BookNode current = head;
        while (current != null) { //Recorrer hasta encontrar el valor
            if (current.data.getId() == id) {

                // caso 1: eliminar la cabeza
                if (current == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                    return true;
                }

                // caso 2: nodo en medio o final
                if (current.prev != null) current.prev.next = current.next;
                if (current.next != null) current.next.prev = current.prev;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void clear() {
        head = null;
    }

    public void printList() {
        BookNode current = head;
        while (current != null) {
            System.out.println(
                current.data.getId() + " - " + current.data.getTitulo()
            );
            current = current.next;
        }
    }

    // Getter para el controller o service
    public BookNode getHead() {
        return head;
    }

}

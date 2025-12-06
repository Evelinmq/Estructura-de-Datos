package mx.edu.utez.integradora.structure;

import mx.edu.utez.integradora.model.Book;

public class BookLinkedList {

    private BookNode head;

    public BookLinkedList() {
        head = null;
    }

    // AGREGAR LIBRO
    public void add(Book book) {
        // Inicializar waitlist si viene null
        if (book.getWaitlist() == null) {
            book.setWaitlist(new ArrayQueue<>()); //tamaño estándar
        }

        // Activar el libro por defecto
        book.setActive(true);

        BookNode newNode = new BookNode(book);

        if (head == null) {
            head = newNode;
        } else {
            BookNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    // BUSCAR POR ID
    public Book findById(int id) {
        BookNode current = head;
        while (current != null) {
            if (current.data.getId() == id) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // ACTUALIZAR LIBRO
    public boolean update(int id, Book updated) {
        BookNode current = head;
        while (current != null) {
            if (current.data.getId() == id) {
                current.data.setTitle(updated.getTitle());
                current.data.setAuthor(updated.getAuthor());
                current.data.setAvaliableCopies(updated.getAvaliableCopies());
                // active y waitlist NO SE MODIFICAN AQUÍ
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // BAJA LÓGICA
    public boolean disable(int id) {
        BookNode current = head;
        while (current != null) {
            if (current.data.getId() == id) {
                current.data.setActive(false);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // OBTENER TODOS LOS LIBROS
    public Book[] getAll() {
        return toArray();
    }

    public BookNode getHead() {
        return head;
    }

    public Book[] toArray() {
        int count = 0;
        BookNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        Book[] arr = new Book[count];
        current = head;
        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }
        return arr;
    }

    //Función buscar por título
    public Book[] searchByTitle(String title) {
        // Contar coincidencias
        BookNode current = head;
        int count = 0;

        while (current != null) {
            if (current.data.getTitle().toLowerCase().contains(title.toLowerCase())) {
                count++;
            }
            current = current.next;
        }

        // Arreglo exacto
        Book[] result = new Book[count];
        current = head;
        int i = 0;

        while (current != null) {
            if (current.data.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result[i++] = current.data;
            }
            current = current.next;
        }

        return result;
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        
        // lista original
        SinglyLinkedList original = new SinglyLinkedList();
        original.add(1);
        original.add(2);
        original.add(3);
        original.add(4);
        original.add(5);

        // listas vacías
        SinglyLinkedList evenList = new SinglyLinkedList();
        SinglyLinkedList oddList = new SinglyLinkedList();

        // Método para separar
        splitEvenOdd(original, evenList, oddList);

        // Imprime
        System.out.println("Original:");
        original.printList();

        System.out.println("Pares:");
        evenList.printList();

        System.out.println("Impares:");
        oddList.printList();
    }

    // Separar pares e impares
    public static void splitEvenOdd(SinglyLinkedList original,
                                    SinglyLinkedList evenList,
                                    SinglyLinkedList oddList) {
        Node current = original.head;

        while (current != null) {
            if (current.data % 2 == 0) {
                evenList.add(current.data);
            } else {
                oddList.add(current.data);
            }
            current = current.next;
        }
    
    }
}

public class App {
    public static void main(String[] args) throws Exception {

        SinglyLinkedList lista = new SinglyLinkedList();

        lista.add(1);
        lista.add(2);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        lista.printList();

        int buscar = 2;
        int ocurrencias = lista.countOccurrences(buscar);
        System.out.println("Ocurrencias de \"" + buscar + "\": " + ocurrencias);
    }
}

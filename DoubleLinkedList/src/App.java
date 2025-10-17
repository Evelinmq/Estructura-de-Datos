public class App {
    public static void main(String[] args) throws Exception {
        
        DoubleLinkedList list = new DoubleLinkedList();
        
        System.out.println("-----------Imprimir lista sin datos---------");
        list.printForward();

        list.add(1);
        list.add(2);
        list.add(5);
        list.add(6);

        System.out.println("-----------Imprimir forward---------");
        list.printForward();
        System.out.println("-----------Remover de la lista---------");
        list.remove(5);
        System.out.println("Forward");
        list.printForward();
        System.out.println("Backward");
        list.printBackward();
    }
}

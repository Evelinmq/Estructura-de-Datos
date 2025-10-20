public class App {
    public static void main(String[] args) throws Exception {
        
        DoubleLinkedList list = new DoubleLinkedList();
        
        System.out.println("-----------Imprimir lista sin datos---------");
        list.printForward();

        list.add(5);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(9);

        System.out.println("-----------Imprimir forward antes de eliminar---------");
        list.printForward();
        System.out.println("-----------Imprimir backward antes de eliminar---------");
        list.printBackward();

        System.out.println("-----------Remover duplicados---------");
        list.removeDuplicates();
        System.out.println("-----> Forward");
        list.printForward();
        System.out.println("-----> Backward");
        list.printBackward();

    }
}

public class BinarySearchTree {

    Node root; //Raíz del árbol

    public void insert (int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {

        //Caso base: cuando current sea nul, en este punto vamos a crear el nodo
        if (current == null) {
            return new Node(value);
        }

        //Si el valor a insertar es menorque el valor de currente
        //Entoces vamos a crear el nodo del lado izquierdo
        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
            //Si el valor a insertar es mayor que el valor current
            //Vamos a crear el nodo del lado derecro
        }else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }
        //En caso de ser números iguales, no se hace nada (para este caso)
        //Pero podrías decidir si lo dejas en el mismo nodo o no

        return current;
    }

    public void printInOrder() {
        System.out.println("--- Print in Order ---");
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(Node current) {
        if (current != null) {
            //Recorrido del lado izquierdo
            printInOrderRecursive(current.left);
            System.out.println(current.value + " ");
            printInOrderRecursive(current.right);
        }
    }
}

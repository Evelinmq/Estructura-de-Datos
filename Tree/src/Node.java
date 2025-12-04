public class Node {
    int value;
    Node left;
    Node right;

    //Fabrica de hojas
    public Node(int value) {
        this.value = value;
        this.left = null; //Se puede omitir ya que al ser un dato primiivo se inicializará en nulo aún así no se declare
        this.right = null;
    }

}

import java.util.ArrayDeque;
import java.util.Deque;

public class App {
    public static void main(String[] args) throws Exception {
        Deque<String> paginas = new ArrayDeque<>();

        paginas.push("PreppyKitchen");
        paginas.push("XaraveMx");
        paginas.push("Receiptify");

        for (String pagina : paginas) {
            System.out.println(pagina);
        }

        //Retroceder página
        paginas.pop();

        //Consulta de página actual
        System.out.println("Página actual: " + paginas.peek());

        //Agregar nueva página
        paginas.push("Farmacias Similares");

        //Contenido de pila
        System.out.println("Stack: " + paginas);

    }
}

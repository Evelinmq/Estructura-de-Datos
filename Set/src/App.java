import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        
        //El set no permite duplicados
        Set<String> set = new TreeSet<>();
                                //HashSet
                                //LinkedHashSet
                                //TreeSet
        set.add("Azul");
        set.add("Verde");
        set.add("Rojo");
        set.add("Amarillo");
        set.add("Rojo"); //Se omitió por duplicidad

        System.out.println(set); //Impresión

        boolean existRed = set.contains("Rojo"); //Existe x objeto
        System.out.println("Existe el rojo? " + existRed);

        set.remove("Verde"); //Eliminar elemento
        int tam = set.size(); //Obtener el tamaño

        for (String data : set) { //Recorrido estándar
            System.out.println("Dato: " + data);
        }
        System.out.println("El tamaño actual es de: " + tam);
    }
}

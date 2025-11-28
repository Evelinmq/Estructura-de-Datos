import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        

        Map<Integer, String> map = new TreeMap<>();
                                        //HashMap
                                        //LinkedHashMap
        map.put(4, "Audifonos");
        map.put(1, "Mouse");
        map.put(2, "Teclado");
        map.put(3, "Monitor");
        map.put(1, "Mouse Gamer"); //Sustituye el valor de la key1

        System.out.println(map);

        String data = map.get(1); //Obtener valor por key
        System.out.println(data);

        //Verifica si existe un valor
        boolean exist = map.containsValue("Teclado"); //Tiene que coincudir exactamante si es búsqueda por valor
        System.out.println("Hay teclado? " + exist);

        map.remove(1);

        //Recorrido estandar
        for (Map.Entry<Integer, String> row : map.entrySet()) {
            System.out.println("La key es: " + row.getKey() + " el valor es " + row.getValue());
        }

        boolean existKey = map.containsKey(1); //Verificar si existe x key
        System.out.println(existKey);
    }
}

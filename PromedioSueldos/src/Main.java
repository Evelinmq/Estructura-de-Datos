import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        
        List<Worker> lista = new ArrayList<>();
        lista.add(new Worker(5460, "Pedro", 10000));
        lista.add(new Worker(5461, "Ana", 800));
        lista.add(new Worker(5462, "Gabriela", 5000));
        lista.add(new Worker(5463, "Santiago", 600));
        lista.add(new Worker(5464, "Maria", 2000));
        lista.add(new Worker(5465, "Kevin", 1100));

        float suma = 0;
        for (Worker w : lista) {
            suma+= w.sueldo;
        }

        float promedio = suma / lista.size();
        System.out.println("Promedio de sueldos: " + promedio);

        lista.remove(1);
        lista.remove(2);

        System.out.println("Lista actualizada: " + lista);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        SelectionSort sorting = new SelectionSort();

        Scanner sc = new Scanner(System.in);
        System.out.println("Cuántas calificaciones deseas registrar?");
        int total = sc.nextInt();
        sc.nextLine();

        String[] estudiantes = new String[total];
        int[] calificaciones = new int[total];
        
        for (int i = 0; i < total; i++) {
            System.out.println("Ingresa el nombre: " );
            estudiantes[i] = sc.nextLine();
            System.out.println("Ingresa calificación: ");
            calificaciones[i] = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("___________Calificaciones antes de ordenar___________");
        for (int i = 0; i < total ; i++) {
            System.out.println(calificaciones[i] + "    " + estudiantes[i]);
        }

        sorting.sort(estudiantes, calificaciones);

        System.out.println("___________Calificaciones ordenadas___________");
        for (int i = 0; i < total ; i++) {
            System.out.println(calificaciones[i] + "    " + estudiantes[i]);
        }

        sc.close();
        
    }
}

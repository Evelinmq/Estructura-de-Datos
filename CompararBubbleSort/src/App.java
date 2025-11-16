import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        BubbleSort sorting = new BubbleSort();
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa el tamaño del arreglo: ");
        int tamaño = sc.nextInt();
        int[] arreglo = new int[tamaño];

        for (int i = 0; i < tamaño; i++) {
            System.out.println("Ingresa número: ");
            int numero = sc.nextInt();
            arreglo[i] = numero;
        }

        System.out.println("_____________Arreglo original_____________");
        System.out.println(Arrays.toString(arreglo));
        System.out.println("_____________Arreglo ordenado_____________");
        sorting.sort(arreglo);

        int min = arreglo[0];
        int max = arreglo[arreglo.length - 1];
        int diferencia = max - min;

        System.out.println("_____________Resultados_____________");
        System.out.println("Valor mínimo: " + min);
        System.out.println("Valor máximo: " + max);
        System.out.println("Diferencia (max - min): " + diferencia);
    
    }
}

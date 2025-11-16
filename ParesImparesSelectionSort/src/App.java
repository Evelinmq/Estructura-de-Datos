import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        SelectionSort sorting = new SelectionSort();
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa la cantidad de números enteros a ingresar");
        int cantidad = sc.nextInt();

        int[] numeros = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingresa el número: ");
            numeros[i] = sc.nextInt();
        }

        int contPares = 0;
        int contImpares = 0;

        for (int i = 0; i < cantidad; i++) {
            if (numeros[i] % 2 ==0) {
                contPares++;
            }else{
                contImpares++;
            }
        }
          
        int[] pares = new int[contPares];
        int[] impares = new int[contImpares];

        int nPares = 0;
        int nImpares = 0;

        for (int i = 0; i < cantidad; i++) {
            if (numeros[i] % 2 == 0) {
                pares[nPares] = numeros[i];
                nPares++;
            }else{
                impares[nImpares] = numeros[i];
                nImpares++;
            }
        }


        System.out.println("_________________Arreglo original_________________");
        System.out.println(Arrays.toString(numeros) + "\n");
        System.out.println("_________________Arreglo pares_________________");
        sorting.sort(pares);
        System.out.println();
        System.out.println("_________________Arreglo impares_________________");
        sorting.sort(impares);

    }
}

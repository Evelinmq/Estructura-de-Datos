import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        
        InsertionSort sorting = new InsertionSort();
        int[] temperaturas = {37, 65, 12, 22, 11, 20, 8, -10, 13, 24};

        System.out.println("__________________Arreglo original__________________");
        System.out.println(Arrays.toString(temperaturas));

        System.out.println("__________________Arreglo ordenado__________________");
        sorting.sort(temperaturas);

        int mayor = temperaturas[(temperaturas.length)-1];
        int menor = temperaturas[0];
        int rango = mayor - menor;

        int[] menores = new int[3];
        int me = 0;
        int[] mayores = new int[3];
        int ma = 0;

        for (int i = 0; i < menores.length; i++) {
            menores[me] = temperaturas[i];
            me++;
        }

        for (int i = temperaturas.length - 1; ma < mayores.length; i--) {
            mayores[ma] = temperaturas[i];
            ma++;
        }

        System.out.println("__________________Resultados__________________");
        System.out.println("Temperadura mínima: " + menor);
        System.out.println("Temperatura máxima: " + mayor);
        System.out.println("Rango: " + rango);
        System.out.println("Temperaturas más altas: " + Arrays.toString(mayores));
        System.out.println("Temperaturas más bajas: " + Arrays.toString(menores)); 
    }
}

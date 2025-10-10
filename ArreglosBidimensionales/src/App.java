import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        
        //Declaración e inicializacion
        int[][] arrBiA = new int[4][4];

        //Declaracion
        int[][] arrBiB;

        //Inicialización
        arrBiB = new int[4][4];
        System.out.println("Arreglo A");
        System.out.println(arrBiA[0][0]);

        //Acceso
        arrBiA[3][3] = 10;

        //Imprimir
        System.out.println("Arreglo B");
        for(int i = 0; i < arrBiB.length; i++){
            for(int j = 0; j < arrBiB.length; j++){
                System.out.println(arrBiB[i][j]);
            }
            System.out.println();
        }
        System.out.println(arrBiB[0][3]);

        //Declaración literal
        int[][] arrBiC = {
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4}
        };

        //Imprimir mediante for each
        System.out.println("Arreglo C");
        for (int[] fila : arrBiC) {
            for (int valor : fila) {
                System.out.println(valor);
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(arrBiC));

        //Arreglo irregular (Jagged)
        int[][] arrBiD = {
            {1, 2, 3},
            {1, 2, 3, 4, 5},
            {1},
            {2, 2, 2, 2, 2, 2}
        };

        System.out.println("Arreglo D");
        System.out.println(Arrays.toString(arrBiD[0]));
        for (int i = 0; i < arrBiD.length; i++) {
            for (int j = 0; j < arrBiD[i].length; j++) {
                System.out.println(arrBiD[i][j]);
            }
            System.out.println();
        }

        //Copiar los valores de un arreglo a otro (no igualar para que no muten)
        int[] a = {1, 2, 3, 4};
        int[] b = new int[4];

        System.out.println("Arreglo antes de copiar");
        System.out.println(Arrays.toString(b));
        
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        System.out.println("Arreglo después de copiar");
        System.out.println(Arrays.toString(b));

        //----------------> Es el equivalente al for
        //System.arraycopy(a, 0, b, 0, 4); <-- "length" Debe ser forzoamente del valor del tamaño del destino

        //Este permite copiar un arreglo y aumentar el tamaño del nuevo arreglo
        int[] c = Arrays.copyOf(a, 5);
        System.out.println("Arreglo C copiado");
        System.out.println(Arrays.toString(c));

        
    }
}

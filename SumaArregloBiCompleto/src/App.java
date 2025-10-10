public class App {
    public static void main(String[] args) throws Exception {
        

        int[][] arrTest={
            {1,3,7,8},
            {0,6,3,1},
            {1,2,3,4},
            {0,5,3,0},
            {2,5,9,0}
        };

        int suma = 0;
        for (int[] fila : arrTest) {
            for (int valor : fila) {
                suma+= valor;
            }
            
        }

        System.out.println("La suma del arreglo es: " + suma);
    }
}

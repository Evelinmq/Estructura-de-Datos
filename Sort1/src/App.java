public class App {
    public static void main(String[] args) throws Exception {
        
        int[][] miArreglo = { 
            {1, 2, 3, 5},
            {4, 5, 6, 7},
            {4, 6, 9, 11},
            {7, 5, 10, 2}
        };

        BubbleSort sorting = new BubbleSort();
            
        for (int i = 0; i < miArreglo.length; i++) { // Recorre las filas
            for (int j = 0; j < miArreglo[i].length; j++) { // Recorre las columnas de la fila actual
                System.out.print(miArreglo[i][j] + " ");
            }
            System.out.println(); // Nueva línea después de cada fila
        }

        for (int i = 0; i < miArreglo.length; i++) {
            sorting.sort(miArreglo[i]);
        }
        
        System.out.println("___________________________________________");
        
        for (int i = 0; i < miArreglo.length; i++) { // Recorre las filas
            for (int j = 0; j < miArreglo[i].length; j++) { // Recorre las columnas de la fila actual
                System.out.print(miArreglo[i][j] + " ");
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }
}

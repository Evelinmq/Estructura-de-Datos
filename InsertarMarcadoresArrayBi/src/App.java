public class App {
    public static void main(String[] args) throws Exception {
        
        int[][] arrTest ={
        {1},           // impar -> agrega 0
        {6,3,1},       // impar -> agrega 0
        {1,2,3,4},     // par   -> agrega (1+4)=5
        {0,5,3,0},     // par   -> agrega (0+0)=0
        {2,5,9},       // impar -> agrega 0
        {2,4,8,9,10}   // impar -> agrega 0
        };

        int arrBi[][] = new int[arrTest.length][];

        for (int i = 0; i < arrBi.length; i++) {
            int cantidad = 0;
            int valor = 0;
            int nuevaLongitud = arrTest[i].length + 1;
            arrBi[i] = new int[nuevaLongitud];

            for (int j = 0; j < arrTest[i].length; j++) {
                arrBi[i][j] = arrTest[i][j];
                cantidad++;
                valor = arrBi[i][j];
            }

            if(cantidad % 2 == 0 ){
                if(valor == 0){
                    arrBi[i][nuevaLongitud - 1] = arrTest[i][arrTest[i].length-1] = 0;
                }else if (valor != 0){
                    arrBi[i][nuevaLongitud - 1] = arrTest[i][arrTest[i].length-1] + 1;
                }
            }else if(cantidad % 2 == 1 ){
                arrBi[i][nuevaLongitud - 1] = arrTest[i][arrTest[i].length-1] = 0;
            }
            
        }


        System.out.println("El nuevo arreglo es:");
        for (int i = 0; i < arrBi.length; i++) {
            System.out.print("");
            for (int j = 0; j < arrBi[i].length; j++) {
                System.out.print(arrBi[i][j] + " ");
            }
            System.out.println();
        }

    }
}

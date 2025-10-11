public class App {
    public static void main(String[] args) throws Exception {
        
         int[][] arrTest={
            {1},
            {6,3,1},
            {1,2,3,4},
            {0,5,3,0},
            {2,5,9},
           {2,4,8,9,10}
        };

        int arrBi[][] = new int[arrTest.length][];

        for (int i = 0; i < arrBi.length; i++) {
            int nuevaLongitud = arrTest[i].length + 1;
            arrBi[i] = new int[nuevaLongitud];

            for (int j = 0; j < arrTest[i].length; j++) {
                arrBi[i][j] = arrTest[i][j];
            }

            arrBi[i][nuevaLongitud - 1] = arrTest[i][arrTest[i].length-1] + 1;
        }

        for (int i = 0; i < arrBi.length; i++) {
            System.out.print("");
            for (int j = 0; j < arrBi[i].length; j++) {
                System.out.print(arrBi[i][j] + " ");
            }
            System.out.println();
        }
    }
}

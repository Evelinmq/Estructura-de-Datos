import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        
        BubbleSort bubblesort = new BubbleSort();
        int[] arr = {4, 2, 9, 2, 4, 7, 1};

        System.out.println("______________Arreglo original______________");
        System.out.println(Arrays.toString(arr) + "\n");

        bubblesort.sort(arr);

        int[] sDuplicados = eliminarDuplicados(arr);
        System.out.println("______________Arreglo ordenado sin duplicados______________");
        System.out.println(Arrays.toString(sDuplicados));
        

    }


    public static int[] eliminarDuplicados(int[] arr){
        int n = arr.length;

        int[] temp = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
                boolean existe = false;
            

            for (int j = 0; j < count; j++) {
                if (arr[i] == temp[j]) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                temp[count] = arr[i];
                count++;
            }

        }

        int[] nuevo = new int[count];
        for (int i = 0; i < count; i++) {
            nuevo[i] = temp[i];
        }
        return nuevo;
    }

}


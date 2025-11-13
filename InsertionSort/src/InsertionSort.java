import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] arr){
        int n = arr.length;

        for (int i = 1; i < n; i++) { //Comenzamos desde el segundo elemento
            int temp = arr[i]; //El primer elemento de la parte desordenada (comparativo)
            int j = i-1; //Comenzamos desde el último elemento de la parte ordenada

            while (j > 0 && arr[j] > temp) { //Recorrer la parte ordenada (fin-inicial)
                //Recorrer la derecha los elementos mayores al temporal
                arr[j+1] = arr[j];
                j--;
            }
            //Insertar ele elemento en su posición correcta
            arr[j+1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

}

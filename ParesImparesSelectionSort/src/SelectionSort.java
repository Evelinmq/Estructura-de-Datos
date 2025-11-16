import java.util.Arrays;

public class SelectionSort {
    
    public void sort(int[] arr){

        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            int minIndex = i; //Selecciona el primero como el menor
            for (int j = i+1; j < arr.length; j++) { //Iniciamos desde la parte no ordenada
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; //Indice del menor dentro de la parte no ordenada
                }
            }
            //Intercambio de posición (pasa el menor a la posición indicada de la parte no ordenada)
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

        }
        System.out.println(Arrays.toString(arr));
    }


}

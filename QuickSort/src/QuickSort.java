public class QuickSort {

    public void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    private void quickSort(int[] arr, int low, int high){
        if (low < high) { //Caso base
            int pivot = partition(arr, low, high); //Realiza la partición del arreglo
            //Llamados recursivos para los subarreglos

            //Arreglar el lado izquierdo
            quickSort(arr, low, pivot-1);

            //Ordenar el lado derecho
            quickSort(arr, pivot+1, high);
        }
    }

    private int partition(int[] arr, int low, int high){
        int pivot = arr[high]; //Selección del pivote (último elemento)
        int i = low - 1; //Establece la frontera de los elementos menores que el pivote

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++; //Incremeneta la frontera de los menores
                swap(arr, i, j); //Realiza el intercambio del elemento corriente a la primera posición de la frontera
            }
        }
        //Mover el pivote a la posición final de la frontera
        swap(arr, i+1, high);
        return i+1; //Devuelve  la posición del pivote
    }

    private void swap(int[] arr, int i, int j){ //Realiza el intercambio de posición de un arreglo
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

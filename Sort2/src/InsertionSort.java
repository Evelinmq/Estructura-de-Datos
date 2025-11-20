public class InsertionSort {

    public void sort(Product[] arr){

        int n= arr.length;

        for (int i = 1; i < n; i++) {//Comenzamos desde el segundo elemento

            Product temp=arr[i]; //el primer elemento de la parte desornadana (comparativo)
            int j = i-1; //comenzamos desde el ultimo elemento de la parte ordenada

            while(j>=0 && arr[j].getPrice() > temp.getPrice()){ //Recorrer la parte ordenada (fin-inicio)
                //recorrer la derecha los elementos mayores al temporal (Falta código)
                arr[j+1] = arr[j];
                j--;

            }

            //insertar el elemento en su posición correcta

            arr[j+1] = temp;

        }
    }

    //System.out.println(Arrays.toString(arr));

}
    

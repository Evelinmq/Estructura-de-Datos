import java.util.Arrays;

public class SelectionSort {

    public void sort(String[] estudiantes, int[] calificaciones){

        int n = calificaciones.length;

        for (int i = 0; i < n-1; i++) {
            int minIndex = i; //Selecciona el primero como el menor
            
            for (int j = i+1; j < n; j++) { //Iniciamos desde la parte no ordenada
                if (calificaciones[j] < calificaciones[minIndex]) {
                    minIndex = j; //Indice del menor dentro de la parte no ordenada
                }
            }
            //Intercambio de posición (pasa el menor a la posición indicada de la parte no ordenada)
            int temp = calificaciones[minIndex];
            calificaciones[minIndex] = calificaciones[i];
            calificaciones[i] = temp;

            String tempEstudiante = estudiantes[minIndex];
            estudiantes[minIndex] = estudiantes[i];
            estudiantes[i] = tempEstudiante;

        }
        //System.out.println(Arrays.toString(arr));
    }

}

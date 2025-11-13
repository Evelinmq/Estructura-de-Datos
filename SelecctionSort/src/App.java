import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        SelectionSort sorting = new SelectionSort();

        int[] arr = {3, 7, 0, 10, 4};
        System.out.println("arreglo antes de ordenar");
        System.out.println(Arrays.toString(arr));
        System.out.println("Arreglo ordenado:");
        sorting.sort(arr);

    }
}

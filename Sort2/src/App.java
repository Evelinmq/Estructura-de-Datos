
public class App {
    public static void main(String[] args) throws Exception {
        
        InsertionSort sorting = new InsertionSort();

        Product[] arr = {
            new Product("Producto 1", 4.0),
            new Product("Producto 2", 10.0),
            new Product("Producto 3", 1.0),
            new Product("Producto 4", 9.0),
            new Product("Producto 5", 3.0),
            new Product("Producto 6", 5.0),
        };
        sorting.sort(arr);
        System.out.println("Arreglo ordenado");
        //System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("Top 3 más baratos");
        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i]);
        }
    }
}

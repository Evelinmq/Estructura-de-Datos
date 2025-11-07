public class App {
    public static void main(String[] args) throws Exception {

        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {1, 5, 9, 10, 3};
        bubbleSort.sort(arr);

        int[] arr2 = {-15, 7, 4, 8, 27};
        bubbleSort.sort(arr2);

    }
}

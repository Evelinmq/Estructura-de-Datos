public class App {

    public static <T> void printArray(T[] array){
        for (T v : array) {
            System.out.println(v);
        }
    }

    public static void main(String[] args) {
        Box<String> box1 = new Box<>("Esta es una caja de strings");

        System.out.println(box1.getValue());
        Box<Integer> box2 = new Box<>(3);
        System.out.println(box2.getValue());
        //List<String> lista = new arrayList<>();

        Pair<String, Integer> pair = new Pair<String, Integer>("id", 3);
        System.out.println("La key es: " + pair.getKey());
        System.out.println("Valor: " + pair.getValue());
        
        
        String[] arrayString = {"Hola1", "Hola2", "Hola3"};
        Integer[] arrayInt = {5,6,8,2};

        System.out.println("____________________________________");
        printArray(arrayString);
        System.out.println("____________________________________");
        printArray(arrayInt);

    }
}

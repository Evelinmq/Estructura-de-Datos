public class App {
    public static void main(String[] args) throws Exception {
        ArrayQueue<Customer> queue = new ArrayQueue<>();

        queue.offer(new Customer(1, "Ana"));
        queue.offer(new Customer(2, "Luis"));
        queue.offer(new Customer(3, "Maya"));

        System.out.println("-----------Antes de invertir-----------");
        queue.print();

        int before = queue.getSize();

        queue.reverse();

        System.out.println("-----------Después de invertir-----------");
        queue.print();

        int after = queue.getSize();

        System.out.println("Elementos antes = " + before + ", elementos después = " + after);
    }
}

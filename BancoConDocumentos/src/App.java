import java.util.ArrayDeque;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        
        Queue<Client> queue = new ArrayDeque<>();

        Client c1 = new Client(1, "Lisa");
        c1.addDocument("Doc 1 de Lisa");
        c1.addDocument("Doc 2 de Lisa");

        Client c2 = new Client(2, "Jackson");
        c2.addDocument("Doc 1 de Jackson");
        c2.addDocument("Doc 2 de Jackson");

        Client c3 = new Client(3, "Jennie");
        c3.addDocument("Doc 1 de Jennie");
        c3.addDocument("Doc 2 de Jennie");

        queue.offer(c1);
        queue.offer(c2);
        queue.offer(c3);

        System.out.println("Atendiendo al cliente: " + queue.peek());
        System.out.println("Retirando documento: " + c1.docs.pop());
        System.out.println("Retirando documento: " + c1.docs.pop());
        queue.poll();

        System.out.println("Atendiendo al cliente: " + queue.peek());
        System.out.println("Retirando documento: " + c2.docs.pop());
        System.out.println("Retirando documento: " + c2.docs.pop());
        queue.poll();

        System.out.println("Atendiendo al cliente: " + queue.peek());
        System.out.println("Retirando documento: " + c3.docs.pop());
        System.out.println("Retirando documento: " + c3.docs.pop());
        queue.poll();
        
        
    }
}

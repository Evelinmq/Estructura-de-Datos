import CustomList.SinglyLinkedList;
import CustomQueue.ArrayQueue;
import CustomStack.ArrayStack;
import java.util.Scanner;
import model.JobCustom;

public class AppPromptExam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayQueue<JobCustom> queue = new ArrayQueue<>();
        ArrayStack<JobCustom> stack = new ArrayStack<>();
        SinglyLinkedList bitacora = new SinglyLinkedList();

        System.out.println("Examen U2 - Despacho express (ADD, PROCESS, COMMIT, UNDO1, PRINT, END)");

        while (true) {
            System.out.println("Ingresa el comando: ");
            String command = sc.nextLine().toUpperCase();

            if (command.equals("ADD")) {
                System.out.println("Ingresa el ID: ");
                String idJob = sc.nextLine();
                JobCustom job = (JobCustom) new JobCustom(idJob);
                queue.offer(job);

            }else if (command.equals("PROCESS")) {
                System.out.println("Ingresa la cantidad a procesar: ");
                int cantidad = sc.nextInt();
                int i = 0;
                while (!queue.isEmpty() && i < cantidad) {
                    stack.push(queue.poll());
                    i++; 
                }

            }else if (command.equals("COMMIT")) {
                while (!stack.isEmpty()) {
                    JobCustom job = (JobCustom) new JobCustom();
                    job = stack.pop();
                    bitacora.addLast(job);
                }

            }else if (command.equals("UNDO")) {
                if (!bitacora.isEmpty()) {
                    queue.offerFront(bitacora.removeLast());
                }else{
                    System.out.println("Nada que hacer");
                }

            }else if (command.equals("PRINT")) {
                printState(queue, stack, bitacora);

            }else if (command.equals("END")) {
                printState(queue, stack, bitacora);
                break;

            }else{
                System.out.println("Comando no reconocido");
            }
        }
    }

    private static void printState(ArrayQueue<JobCustom> queue, ArrayStack<JobCustom> stack, SinglyLinkedList bitacora) {
        System.out.print("QUEUE (pendientes): ");
        queue.print();
        System.out.print("STACK (procesando): ");
        stack.print();
        System.out.println("BITACORA (confirmados): " + bitacora.toString());
    }
}

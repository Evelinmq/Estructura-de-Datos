import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        
        Scanner sc = new Scanner(System.in);
        ArrayQueue<JobCustom> queue = new ArrayQueue<>();
        ArrayStack<JobCustom> stack = new ArrayStack<>();
        SinglyLinkedList list = new SinglyLinkedList();

        while (true) { 
            System.out.println("Ingresa el comando");
            String cmd = sc.nextLine().toUpperCase(); //Esto vuelve la recolección de la consola en mayusculas
            if(cmd.equals("ADD")){
                System.out.println("Dame el Id: ");
                String idJob = sc.nextLine();
                JobCustom job = new JobCustom(idJob);
                //job.setId(idJob);
                queue.offer(job);

            }else if(cmd.equals("PROCESS")){
                System.out.println("Dame la cantidad a procesar: "); //Esto deberia ir dentro de un try catch
                int num = sc.nextInt();
                sc.nextLine();
                int cont = 0;
                //Se va a recorrer mientras no esté vacía y mientras el contador sea menor que el numero de posición
                while(!queue.isEmpty() && cont < num){
                    JobCustom job = (JobCustom) queue.poll(); //Obtener el elemento de la queue y lo casteamos a JobCustom
                    stack.push(job);
                    cont++;
                }

            }else if (cmd.equals("COMMIT")) {
                while (!stack.isEmpty()) {  //Recorrido de la stack
                    list.add(stack.pop()); //Se ingresa el elemento que sacamos de la stack a la lista
                }
            }else if(cmd.equals("PRINT")){
                printData(queue, stack, list);

            }else if(cmd.equals("ROLLBACK")){
                System.out.println("Ingresa la cantidad a revertir");
                int r = sc.nextInt();
                sc.nextLine();

                int maximos = list.size();
                int revertir;

                if (r > maximos) {
                    revertir = maximos;
                } else {
                    revertir = r;
                }

                int trabajosRevertidos = 0;
                ArrayStack<JobCustom> tempStack = new ArrayStack<>();
                for (int i = 0; i < revertir; i++) {
                    JobCustom job = (JobCustom) list.removeLast();
                    if (job != null) {
                        tempStack.push(job);
                        trabajosRevertidos++;
                    }
                }

                ArrayStack<JobCustom> queueStack = new ArrayStack<>();
                while (!queue.isEmpty()) {
                    queueStack.push((JobCustom) queue.poll());
                }

                while (!tempStack.isEmpty()) {
                    queue.offer(tempStack.pop());
                }

                while (!queueStack.isEmpty()) {
                    queue.offer(queueStack.pop());
                }

            }else if(cmd.equals("END")){
                break;

            }else{
                System.out.println("Comando no reconocido");
            }
        }

    }

    public static void printData(ArrayQueue queue, ArrayStack stack, SinglyLinkedList list){
        System.out.println("Queue: ");
        queue.print();
        System.out.println("Stack: ");
        stack.print();
        System.out.println("Commit: ");
        list.printList();
    }
}

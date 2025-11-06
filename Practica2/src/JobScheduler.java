public class JobScheduler {

    private ArrayQueue<Job> pendientes; //Queue
    private ArrayStack<Job> procesados; //Stack
    private SingleLinkedList<Job> commited; //LinkedList

    public JobScheduler() {
        this.pendientes = new ArrayQueue<>();
        this.procesados = new ArrayStack<>();
        this.commited = new SingleLinkedList<>();
    }

    public void processCommand(String line) {
        if (line == null) return;

        int len = line.length();
        char firstChar = line.charAt(0);

        if (firstChar == 'A' && len > 4) {
            handleAdd(line);
        } else if (firstChar == 'P' && len > 8) {
            handleProcess(line);
        } else if (firstChar == 'R' && len > 9) {
            handleRollback(line);
        } else if (len == 6 && firstChar == 'C') {
            handleCommit();
        } else if (len == 3 && firstChar == 'E') {
            handleEnd();
        }
    }

    private void handleAdd(String line) {
        String id = line.substring(4);
        pendientes.offer(new Job(id));
    }

    private void handleProcess(String line) {
        String arg = line.substring(8);
        int n = Integer.parseInt(arg);

        for (int i = 0; i < n && !pendientes.isEmpty(); i++) {
            procesados.push(pendientes.poll());
        }
    }

    private void handleCommit() {
        while (!procesados.isEmpty()) {
            commited.addLast(procesados.pop());
        }
    }

    private void handleRollback(String line) {
        String arg = line.substring(9);
        int m = Integer.parseInt(arg);

        int jobsToRevert = Math.min(m, commited.size());
        int count = 0;

        ArrayStack<Job> tempReverted = new ArrayStack<>();

        for (int i = 0; i < jobsToRevert; i++) {
            Job job = commited.removeLast();
            tempReverted.push(job);
            count++;
        }

        ArrayStack<Job> currentQueueJobs = new ArrayStack<>();
        while(!pendientes.isEmpty()) currentQueueJobs.push(pendientes.poll());
        while(!tempReverted.isEmpty()) pendientes.offer(tempReverted.pop());
        while(!currentQueueJobs.isEmpty()) pendientes.offer(currentQueueJobs.pop());
    }

    private void handleEnd() {
        System.out.println("***--- ESTADO FINAL ---***");
        System.out.print("Pendientes: "); pendientes.print();
        System.out.print("Procesando: "); procesados.print();
        System.out.print("BITÁCORA: "); commited.print();

    }
}
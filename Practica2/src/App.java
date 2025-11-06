public class App {
    public static void main(String[] args) {

        JobScheduler scheduler = new JobScheduler();

        String[] commands = {
                "ADD A", "ADD B", "ADD C",
                "PROCESS 2",
                "PRINT",
                "COMMIT",
                "ROLLBACK 1",
                "ADD D",
                "PROCESS 3",
                "COMMIT",
                "END"
        };
        for (String command : commands) {
            scheduler.processCommand(command);
        }
    }
}
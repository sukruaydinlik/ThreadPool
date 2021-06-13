public class Main {
    public static void main(String[] args) {
        // Let's start with creating the jobs
        TaskFactory taskFactory = new TaskFactory();
        for (int i = 0; i < 50; i++) {

            System.out.println(taskFactory.getTask().toString());

        }
    }
}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TaskFactory taskFactory = new TaskFactory();
        ThreadRepo threadRepo = new ThreadRepo();
        ThreadFactory threadFactory = new ThreadFactory();

        for (int i = 0; i < 50; i++) {

            // Create random task.
            TaskInterface task = taskFactory.getTask();
            int priority = task.getPriorityLevel();

            // Create a thread and assign created task to it.
            ThreadInterface ti = threadFactory.getThread(priority, task);

            // Add thread to thread repo.
            threadRepo.getThreads().add(ti);


        }
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (Iterator iterator = threadRepo.getIterator(); iterator.hasNext(); ) {
            ThreadInterface thread = (ThreadInterface) iterator.next();
            executorService.execute(thread);

            //thread.run();
        }

    }
}

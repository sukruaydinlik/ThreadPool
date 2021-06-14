import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        TaskFactory taskFactory = new TaskFactory();
        ThreadRepo threadRepo = new ThreadRepo();
        ThreadFactory threadFactory = new ThreadFactory();
        ThreadPoolExecutingService tpes = new ThreadPoolExecutingService();


        for (int i = 0; i < 50; i++) {

            // Create random task.
            TaskInterface task = taskFactory.getTask();
            int priority = task.getPriorityLevel();

            // Create a thread and assign created task to it.
            ThreadInterface ti = threadFactory.getThread(priority, task);

            // Add thread to thread repo, or in this case: ThreadPool.
            threadRepo.getThreads()[i] = ti;

        }

        for (Iterator iterator = threadRepo.getIterator(); iterator.hasNext(); ) {
            ThreadInterface thread = (ThreadInterface) iterator.next();

            if (thread.getTask().getPriorityLevel() == 1) {
                RunHThreads rht = new RunHThreads(thread);
                tpes.takeOrder(rht);
            } else {
                RunLThreads rlt = new RunLThreads(thread);
                tpes.takeOrder(rlt);
            }
        }
        tpes.placeOrders();
    }
}

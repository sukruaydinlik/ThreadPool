public class Main {
    public static void main(String[] args) {
        // Let's start with creating the jobs
        TaskFactory taskFactory = new TaskFactory();
        ThreadRepo threadRepo = new ThreadRepo();
        ThreadFactory threadFactory = new ThreadFactory();

        for (int i = 0; i < 50; i++) {

            TaskInterface task = taskFactory.getTask();
            int priority = task.getPriorityLevel();
            ThreadInterface ti = threadFactory.getThread(priority, task);
            threadRepo.getThreads().add(ti);
        }

    }
}

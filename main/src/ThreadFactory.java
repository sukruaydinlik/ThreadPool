import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * This file simulates a thread creator
 * using factory pattern
 */
interface ThreadInterface extends Runnable {
    TaskInterface getTask();
    void displayInfo();
}

class LThread implements ThreadInterface {
    private TaskInterface task;

    public LThread(TaskInterface task) {
        this.task = task;
    }

    public TaskInterface getTask() {
        return task;
    }

    public void setTask(TaskInterface task) {
        this.task = task;
    }

    @Override
    public void displayInfo() {
        System.out.println("LThread created. "+task.toString());
    }

    @Override
    public void run() {
        System.out.println("Executing task " + task.toString() +".");
        task.displayInfo();
    }
}

class HThread implements ThreadInterface {
    private TaskInterface task;

    public HThread(TaskInterface task) {
        this.task = task;
    }

    public TaskInterface getTask() {
        return task;
    }

    public void setTask(TaskInterface task) {
        this.task = task;
    }

    @Override
    public void displayInfo() {
        System.out.println("HThread created. "+task.toString());
    }

    @Override
    public void run() {
        System.out.println("Executing task " + task.toString() +".");
    }
}

public class ThreadFactory {
    private ArrayList<String> taskPool;

    public ThreadFactory() {
        taskPool = new ArrayList<String>();
    }

public ThreadInterface getThread(int priority, TaskInterface task) {

        if (priority == 5) {
            return new LThread(task);
        } else {
            return new HThread(task);
        }
    }

}

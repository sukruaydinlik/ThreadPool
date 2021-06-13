import java.security.SecureRandom;
import java.util.ArrayList;

interface ThreadInterface extends Runnable {
    public void displayInfo();
}

class SmallThread implements ThreadInterface {
    private TaskInterface task;

    public SmallThread(TaskInterface task) {
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
        System.out.println(task.toString());
    }

    @Override
    public void run() {
        System.out.println("Executing task " + task.toString() +".");
    }
}

class BigThread implements ThreadInterface {
    private TaskInterface task;

    public BigThread(TaskInterface task) {
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
        System.out.println(task.toString());
    }

    @Override
    public void run() {
        System.out.println("Executing task " + task.toString() +".");
    }
}

public class ThreadFactory {
    private ArrayList<String> taskPool;

    public ThreadFactory() {
//        secureRandom = new SecureRandom();
        taskPool = new ArrayList<String>();
    }

//    public ThreadInterface getTask() {
//        int random = secureRandom.nextInt(10);
//        String description = taskPool.get(random);
//
////        System.out.println(random);
//        if (random < 5) {
//            return new SmallThread(5, description);
//        } else {
//            return new BigThread(1, description);
//        }
//    }

}

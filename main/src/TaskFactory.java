import java.security.SecureRandom;
import java.util.ArrayList;


/**
 * This file chooses given jobs and
 * creates a task by benefiting from
 * Factory Pattern
 */
abstract class TaskInterface {
    int priorityLevel = 0;

    public int getPriorityLevel() {
        return priorityLevel;
    }

    void displayInfo() {

    }
}

class SmallTask extends TaskInterface {
    private int priorityLevel;
    private String description;


    public SmallTask(int priorityLevel, String desc) {
        this.priorityLevel = priorityLevel;
        this.description = desc;
    }

    @Override
    public void displayInfo() {

    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SmallTask{" +
                "priorityLevel=" + priorityLevel +
                ", desc='" + description + '\'' +
                '}';
    }
}

class BigTask extends TaskInterface {
    private int priorityLevel;
    private String description;

    public BigTask(int priority, String desc) {
        this.priorityLevel = priority;
        this.description = desc;
    }

    @Override
    public void displayInfo() {

    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BigTask{" +
                "priorityLevel=" + priorityLevel +
                ", description='" + description + '\'' +
                '}';
    }
}

public class TaskFactory {
    private SecureRandom secureRandom;
    private ArrayList<String> taskPool;

    public TaskFactory() {
        secureRandom = new SecureRandom();
        taskPool = new ArrayList<String>();
        fillList();
    }

    public TaskInterface getTask() {
        int random = secureRandom.nextInt(10);
        String description = taskPool.get(random);

//        System.out.println(random);
        if (random > 4) {
            return new SmallTask(5, description);
        } else {
            return new BigTask(1, description);
        }
    }

    private void fillList() {
        taskPool.add("Run CSGO");
        taskPool.add("Compile a Java code");
        taskPool.add("Run Java code");
        taskPool.add("Run Android Studio");
        taskPool.add("Clean Memory");
        taskPool.add("Open file");
        taskPool.add("Install driver");
        taskPool.add("Open Chrome Web Browser");
        taskPool.add("Open Die Hard.mp4");
        taskPool.add("Play music");
    }
}

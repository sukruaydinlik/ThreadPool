import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;

interface TaskInterface {
    public void displayInfo();
}

class SmallTask implements TaskInterface {
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

class BigTask implements TaskInterface {
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
        if (random < 5) {
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

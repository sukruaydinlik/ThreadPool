
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

    public TaskInterface getSmallTask(int type, String description) {
        if (type == 0) {
            return new SmallTask(5, description);
        } else if (type == 1) {
            return new BigTask(1, description);
        }else{
            System.out.println("Incorrect type entered. Type 0 for SmallTask and type 1 for BigTask");
            return null;
        }
    }
}
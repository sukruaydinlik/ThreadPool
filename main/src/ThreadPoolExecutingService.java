import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * In this file, a simple thread pool executing service is
 * simulated by using command pattern.
 */
public class ThreadPoolExecutingService {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {

        // Sort threads in ascending order of priority
        Collections.sort(orderList, (o1, o2) -> {
            if (o1.getThread().getTask().getPriorityLevel() == o2.getThread().getTask().getPriorityLevel())
                return 0;
            return o1.getThread().getTask().getPriorityLevel() < o2.getThread().getTask().getPriorityLevel() ? -1 : 1;
        });

        // Execute all orders
        for (Order order : orderList) {
            order.executeOrder();
        }

        orderList.clear();
    }
}

// Interface for commands of a thread
interface Order {

    ThreadInterface getThread();

    void executeOrder();
}


// Command which implements Order
class RunLThreads implements Order {
    private ThreadInterface thread;

    @Override
    public ThreadInterface getThread() {
        return thread;
    }

    public RunLThreads(ThreadInterface thread) {
        this.thread = thread;
    }

    @Override
    public void executeOrder() {
        thread.run();
    }
}

// Another Command which implements Order
class RunHThreads implements Order {
    private ThreadInterface thread;

    @Override
    public ThreadInterface getThread() {
        return thread;
    }

    public RunHThreads(ThreadInterface thread) {
        this.thread = thread;
    }

    @Override
    public void executeOrder() {
        thread.run();
    }
}
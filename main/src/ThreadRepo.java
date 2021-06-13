import java.util.ArrayList;

interface Container {
    Iterator getIterator();
}

interface Iterator {
    boolean hasNext();

    Object next();
}


public class ThreadRepo implements Container {
    private ArrayList<Thread> threads ;

    public ThreadRepo() {
        this.threads = new ArrayList<Thread>();
    }

    @Override
    public Iterator getIterator() {

        return new ThreadIterator();
    }

    public ArrayList<Thread> getThreads() {
        return threads;
    }

    public void setThreads(ArrayList<Thread> threads) {
        this.threads = threads;
    }

    private class ThreadIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            if (index < threads.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                return threads.get(index++);
            }
            return null;
        }
    }
}

import java.util.ArrayList;

interface Container {
    Iterator getIterator();
}

interface Iterator {
    boolean hasNext();

    Object next();
}


public class ThreadRepo implements Container {
    private ArrayList<ThreadInterface> threads;

    public ArrayList<ThreadInterface> getThreads() {
        return threads;
    }

    public void setThreads(ArrayList<ThreadInterface> threads) {
        this.threads = threads;
    }

    public ThreadRepo() {
        this.threads = new ArrayList<ThreadInterface>();
    }

    @Override
    public Iterator getIterator() {
        return new ThreadIterator();
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

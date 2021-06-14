import java.util.ArrayList;

/**
 * This file simulates a thread queue by using
 * Iterator Pattern
 */

interface Container {
    Iterator getIterator();
}

interface Iterator {
    boolean hasNext();

    Object next();
}


public class ThreadRepo implements Container {
    private ThreadInterface[] threads;

    public ThreadInterface[] getThreads() {
        return threads;
    }

    public ThreadRepo() {

        // Specified number of threads is 50
        this.threads = new ThreadInterface[50];
    }

    @Override
    public Iterator getIterator() {
        return new ThreadIterator();
    }


    private class ThreadIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            if (index < threads.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return threads[index++];
            }
            return null;
        }
    }
}

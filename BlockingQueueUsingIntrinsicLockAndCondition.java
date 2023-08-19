import java.util.LinkedList;

public class BlockingQueueUsingIntrinsicLockAndCondition<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private final LinkedList<T> queue;
    private final int capacity;

    private final Object lock = new Object();

    public BlockingQueueUsingIntrinsicLockAndCondition() {
        this(DEFAULT_CAPACITY);
    }

    public BlockingQueueUsingIntrinsicLockAndCondition(final int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public void add(final T element) {
        synchronized (lock) {
            while (queue.size() == capacity) {

                System.out.println("Thread waiting on full condition " + Thread.currentThread()
                        .getName());

                try {
                    lock.wait();
                } catch (final InterruptedException e) {
                    System.out.println("Thread interrupted " + Thread.currentThread()
                            .getName());
                    throw new RuntimeException(e);
                }
            }
            queue.add(element);
            lock.notifyAll();
        }
    }

    public T remove() {
        synchronized (lock) {
            while (queue.isEmpty()) {

                System.out.println("Thread waiting on empty condition " + Thread.currentThread()
                        .getName());

                try {
                    lock.wait();
                } catch (final InterruptedException e) {
                    System.out.println("Thread interrupted " + Thread.currentThread()
                            .getName());
                    throw new RuntimeException(e);
                }
            }
            final T element = queue.remove();
            lock.notifyAll();
            return element;
        }

    }
}

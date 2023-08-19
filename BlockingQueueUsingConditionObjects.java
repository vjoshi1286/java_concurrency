import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueUsingConditionObjects<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private final LinkedList<T> queue;
    private final int capacity;
    private final Lock lock;
    private final Condition fullCondition;
    private final Condition emptyCondition;

    public BlockingQueueUsingConditionObjects() {
        this(DEFAULT_CAPACITY);
    }

    public BlockingQueueUsingConditionObjects(final int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        emptyCondition = lock.newCondition();
    }

    public void add(final T element) {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                try {
                    System.out.println("Thread " + Thread.currentThread()
                            .getName() + " Waiting on full condition");
                    fullCondition.await();
                } catch (final InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            queue.add(element);

            emptyCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public T remove() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                try {
                    System.out.println("Thread " + Thread.currentThread()
                            .getName() + " Waiting on empty condition");
                    emptyCondition.await();
                } catch (final InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            final T element = queue.remove();
            fullCondition.signalAll();
            return element;
        } finally {
            lock.unlock();
        }
    }

}

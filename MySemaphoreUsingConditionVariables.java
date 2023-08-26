import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MySemaphoreUsingConditionVariables {
    private int numberOfPermits;

    private final Lock lock = new ReentrantLock();
    private final Condition permitAvailableCondition = lock.newCondition();

    public MySemaphoreUsingConditionVariables(final int numberOfPermits) {
        this.numberOfPermits = numberOfPermits;
    }

    public void acquire() {
        try {
            lock.lock();
            while (numberOfPermits <= 0) { //For historical reasons as Semaphore can have -ve number of initial permits
                permitAvailableCondition.await();
            }
            numberOfPermits--;
        } catch (final InterruptedException interruptedException) {
            throw new RuntimeException(interruptedException);
        } finally {
            lock.unlock();
        }
    }

    public void release() {
        try {
            lock.lock();
            numberOfPermits++;
            permitAvailableCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}

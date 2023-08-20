import java.util.concurrent.Semaphore;

public abstract class AbstractPingPongTemplateMethodThread extends Thread {
    private static final int N_ITERATIONS = 1_000;
    private final Semaphore mine;
    private final Semaphore other;

    AbstractPingPongTemplateMethodThread(final Semaphore mine, final Semaphore other) {
        this.mine = mine;
        this.other = other;
    }

    /* Run now becomes a template method pattern */
    @Override
    public final void run() {
        for (int i = 0; i < N_ITERATIONS; i++) {
            acquire();
            print();
            release();
        }
    }

    protected abstract void print();

    private void release() {
        other.release();
    }

    private void acquire() {
        try {
            mine.acquire();
        } catch (final InterruptedException ie) {
            throw new RuntimeException(ie);
        }

    }
}

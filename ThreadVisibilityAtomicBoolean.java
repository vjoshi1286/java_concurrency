import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadVisibilityAtomicBoolean {

    private static class RunThread extends Thread {
        private final AtomicBoolean stopped;

        private RunThread() {
            this.stopped = new AtomicBoolean(false);
        }

        @Override
        public void run() {
            int cnt = 0;
            while (!stopped.get()) {
                cnt++;
            }
        }

        public void stopMe() {
            stopped.set(true);
        }
    }

    public static void main(String[] args) {
        final var runThread = new RunThread();
        runThread.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        runThread.stopMe();
        System.out.println("Main Thread exits ...");
    }
}

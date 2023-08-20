import java.util.concurrent.Semaphore;

public class PingThread extends Thread {
    private final Semaphore pingSemaphore;
    private final Semaphore pongSemaphore;

    public PingThread(final Semaphore pingSemaphore, final Semaphore pongSemaphore) {
        this.pingSemaphore = pingSemaphore;
        this.pongSemaphore = pongSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                pingSemaphore.acquire();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Ping");
            pongSemaphore.release();

        }
    }
}

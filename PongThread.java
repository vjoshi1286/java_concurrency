import java.util.concurrent.Semaphore;

public class PongThread extends Thread {

    private final Semaphore pingSemaphore;
    private final Semaphore pongSemaphore;

    public PongThread(final Semaphore pingSemaphore, final Semaphore pongSemaphore) {
        this.pingSemaphore = pingSemaphore;
        this.pongSemaphore = pongSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                pongSemaphore.acquire();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Pong");
            pingSemaphore.release();
        }
    }
}

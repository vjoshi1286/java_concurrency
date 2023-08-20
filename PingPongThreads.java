import java.util.concurrent.Semaphore;

public class PingPongThreads {
    public static void main(String[] args) {
        final Semaphore pingSemaphore = new Semaphore(1);
        final Semaphore pongSemaphore = new Semaphore(0);

        new PingThread(pingSemaphore, pongSemaphore).start();
        new PongThread(pingSemaphore, pongSemaphore).start();

        System.out.println("Main Thread exits");

    }
}

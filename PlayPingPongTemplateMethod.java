import java.util.concurrent.Semaphore;

public class PlayPingPongTemplateMethod {
    public static void main(String[] args) {
        final Semaphore ping = new Semaphore(1);
        final Semaphore pong = new Semaphore(0);
        new PingThreadWithTemplateMethod(ping, pong).start();
        new PongThreadWithTemplateMethod(pong, ping).start();

        System.out.println("Main thread exits after starting ping-pong game");
    }
}

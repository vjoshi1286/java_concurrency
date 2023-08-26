public class PingPongUsingMySemaphore {

    public static void main(String[] args) {

        final MySemaphoreUsingConditionVariables ping = new MySemaphoreUsingConditionVariables(1);
        final MySemaphoreUsingConditionVariables pong = new MySemaphoreUsingConditionVariables(0);

        final PingUsingMySemaphore pingThread = new PingUsingMySemaphore(ping, pong);
        final PongUsingMySemaphore pongThread = new PongUsingMySemaphore(pong, ping);

        pingThread.start();
        pongThread.start();

        System.out.println("Main thread exits, ping and pong demo");

    }
}

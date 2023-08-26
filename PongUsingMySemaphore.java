public class PongUsingMySemaphore extends Thread{
    private final MySemaphoreUsingConditionVariables mine;
    private final MySemaphoreUsingConditionVariables theirs;

    public PongUsingMySemaphore(MySemaphoreUsingConditionVariables mine,
                                MySemaphoreUsingConditionVariables theirs) {
        this.mine = mine;
        this.theirs = theirs;
    }

    @Override
    public void run() {
        while (true) {
            mine.acquire();
            SleepUtil.sleep(2000);
            System.out.println("PONG");
            theirs.release();
        }
    }

}

public class PingUsingMySemaphore extends Thread {

    private final MySemaphoreUsingConditionVariables mine;
    private final MySemaphoreUsingConditionVariables theirs;

    public PingUsingMySemaphore(MySemaphoreUsingConditionVariables mine,
                                MySemaphoreUsingConditionVariables theirs) {
        this.mine = mine;
        this.theirs = theirs;
    }

    @Override
    public void run() {
        while (true) {
            mine.acquire();
            SleepUtil.sleep(2000);
            System.out.println("PING");
            theirs.release();
        }
    }
}

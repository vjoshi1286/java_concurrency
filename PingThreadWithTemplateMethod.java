import java.util.concurrent.Semaphore;

public class PingThreadWithTemplateMethod extends AbstractPingPongTemplateMethodThread {

    public PingThreadWithTemplateMethod(final Semaphore mine, final Semaphore other) {
        super(mine, other);
    }

    @Override
    protected void print() {
        SleepUtil.sleep(2000);
        System.out.println("PING");
    }
}

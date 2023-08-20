import java.util.concurrent.Semaphore;

public class PongThreadWithTemplateMethod extends AbstractPingPongTemplateMethodThread {
    public PongThreadWithTemplateMethod(final Semaphore mine, final Semaphore other) {
        super(mine, other);
    }

    @Override
    protected void print() {
        SleepUtil.sleep(2000);
        System.out.println("PONG");
    }
}

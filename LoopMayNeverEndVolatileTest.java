public class LoopMayNeverEndVolatileTest {
    public static void main(final String[] args) {

        final var loopMayNeverEnd = new LoopMayNeverEndVolatile();

        final Thread t1 = new Thread(loopMayNeverEnd::work);

        final Thread t2 = new Thread(() -> {
            SleepUtil.sleep(2000);
            loopMayNeverEnd.stopWork();
        });

        t1.start();
        t2.start();

        System.out.println("Main thread exits now");
    }
}

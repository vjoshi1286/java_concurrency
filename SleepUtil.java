public class SleepUtil {

    private SleepUtil() {
        throw new UnsupportedOperationException("Initialization not allowed");
    }

    public static void sleep(final int nMiliSeconds) {
        try {
            Thread.sleep(nMiliSeconds);
        } catch (final InterruptedException interruptedException) {
            throw new RuntimeException("Thread with name " + Thread.currentThread()
                    .getName() + " is interrupted ", interruptedException);

        }
    }
}

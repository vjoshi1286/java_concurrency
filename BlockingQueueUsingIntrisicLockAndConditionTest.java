public class BlockingQueueUsingIntrisicLockAndConditionTest {

    public static void main(final String[] args) {

        final var queue = new BlockingQueueUsingIntrinsicLockAndCondition<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread()
                        .getName());
                queue.add("test");
            }).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread()
                        .getName());
                System.out.println(queue.remove());
            }).start();
        }
    }

}

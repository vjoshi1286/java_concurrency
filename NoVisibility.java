public class Test{
    
    private static boolean ready;
    private static int val;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready);
            
		System.out.println(val + " " + Thread.currentThread()
                    .getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
	Thread.sleep(4000);
        ready = true;
        val = 42;
    }
}

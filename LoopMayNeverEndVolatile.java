public class LoopMayNeverEndVolatile {
    private boolean done = false;
    private int cnt = 0;

    public void work() {
        while (!done) {
            cnt++;
        }

        System.out.println("Done "+ cnt);
    }

    public void stopWork() {
        done = true;
    }
}

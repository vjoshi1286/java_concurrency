
/* A program will be free from lock-ordering deadlocks if all the threads acquire
the locks in fixed global order. */
public class LockSequenceDeadLockTest{

	public static void main(final String[] args){
		final Thread t1 = new Thread(() -> LockSequenceDeadLock.leftToRight());
		final Thread t2 = new Thread(() -> LockSequenceDeadLock.rightToLeft());

		t1.start();
		t2.start();

		System.out.println("Main Thread exitted");

	}

}
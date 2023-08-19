public class LockSequenceDeadLock{

	private static final Object left = new Object();
	private static final Object right = new Object();


	public static void leftToRight(){
		synchronized(left){
			System.out.println("Thread leftToRight "
				+ Thread.currentThread().getName());
			sleep();
			synchronized(right){
				sleep();
			}
			
		}

	}

	public static void rightToLeft(){
		synchronized(right){
			System.out.println("Thread rightToLeft "
				+ Thread.currentThread().getName());
		
			sleep();
			synchronized(left){
				sleep();
			}

		}

	}
	
	private static void sleep(){
		try{
			Thread.sleep(5000);
		}catch(final InterruptedException e){

			System.out.println("Thread interrupted "
				+ Thread.currentThread().getName());
		}
		
	}

}
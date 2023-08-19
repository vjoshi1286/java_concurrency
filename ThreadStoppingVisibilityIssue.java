
public class ThreadStoppingVisibilityIssue{
	
	private static volatile boolean ready = false;
	
	private static class InnerThread extends Thread{
		@Override
		public void run(){
			int cnt =0;
			while(!ready){
				cnt++;
			}
			System.out.println("Inner thread is done");
		}

	}
	

	public static void main(final String[] args) throws InterruptedException{
		new InnerThread().start();
		Thread.sleep(2000);
		ready = true;
		System.out.println("Main thread done");
	}

}
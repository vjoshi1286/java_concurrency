public class MutableIntegerTester{

	public static void main(final String... args){
		final MutableInteger mi = new MutableInteger();
	
		final Thread t1 = new Thread(()->{
				int n =0;
				while(n <= 1_000){
					n++;
				System.out.println(mi.getValue());
				}	
			
					
			});


		final Thread t2 = new Thread(()->{
				int n =0;
				while(n <= 1_000){
				  mi.setValue(n);
				  n++;
				}
			});
		
		t1.start();
		t2.start();
	}
}
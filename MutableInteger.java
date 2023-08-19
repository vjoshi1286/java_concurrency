public class MutableInteger{
	private int value;

	public synchronized void setValue(final int value){
		this.value = value;
	}

	public synchronized int getValue(){
		return value;
	}

}
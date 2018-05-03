import java.util.concurrent.TimeUnit;

public class MethodList implements Runnable{

	@Override
	public void run() {
		
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(5));
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		MethodList obj = new MethodList();
		
		Thread thrdObj = new Thread(obj);
		
		//Priority set 1 to 10
		thrdObj.setPriority(Thread.MIN_PRIORITY);	// Priority number 1
		thrdObj.setPriority(Thread.NORM_PRIORITY);	// Priority number 5
		thrdObj.setPriority(Thread.MAX_PRIORITY); 	// Priority number 10
		
		
	}

}

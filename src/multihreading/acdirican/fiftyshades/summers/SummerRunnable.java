package multihreading.acdirican.fiftyshades.summers;

import java.util.concurrent.Callable;

import multihreading.acdirican.fiftyshades.worker.WorkPartitioner.Part;

/**
 * {@link Runnable} based {@link Summer).
 * 
 * @author Ahmet Cengizhan Dirican
 * @see https://github.com/acdirican
 */
public class SummerRunnable extends Summer implements Runnable{
	
	private Thread thread;
	
	public SummerRunnable(int[] data, Part part) {
		super(data, part);
	}

	@Override
	public void run() {
		sum = 0;
		for (int i = start; i < finish; i++) {
			sum += data[i];
		}
	}
	
	public void startThread() {
		thread =  new Thread(this);
		thread.start();
	}

	public void joinThread() throws InterruptedException {
		thread.join();
	}	
}
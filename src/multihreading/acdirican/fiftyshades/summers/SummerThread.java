package multihreading.acdirican.fiftyshades.summers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import multihreading.acdirican.fiftyshades.worker.WorkPartitioner.Part;

/**
 * {@link Thread} based summer/worker Because this class cannot extends the {@link Summer}, 
 * it had to include the similar code.
 * 
 * @author Ahmet Cengizhan Dirican
 * @see https://github.com/acdirican
 */
public class SummerThread extends Thread{
	private int start;
	private int finish;
	private int[] data;
	private long sum;
	
	public SummerThread(int[] data, int start, int finish) {
		this.start = start;
		this.finish = finish;
		this.data = data;
	}

	public SummerThread(int[] data, Part part) {
	    this(data, part.getStart(), part.getFinish());
	}

	@Override
	public void run() {
		sum = 0;
		for (int i = start; i < finish; i++) {
			sum += data[i];
		}
	}

	public long getSum() {
		return sum;
	}
	
}
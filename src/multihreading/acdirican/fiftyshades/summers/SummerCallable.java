package multihreading.acdirican.fiftyshades.summers;
import java.util.concurrent.Callable;

import multihreading.acdirican.fiftyshades.worker.Worker;
import multihreading.acdirican.fiftyshades.worker.WorkPartitioner.Part;

/**
 * {@link Callable} based {@link Summer).
 * 
 * @author Ahmet Cengizhan Dirican
 * @see https://github.com/acdirican
 */
public class SummerCallable extends Summer implements Callable<Long> {
	
	public SummerCallable(int[] data, Part part) {
		super(data, part);
	}

	@Override
	public Long call() throws Exception {
		this.sum = 0;
		for (int i = start; i < finish; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	

}
package multihreading.acdirican.fiftyshades.summers;

import multihreading.acdirican.fiftyshades.worker.Worker;
import multihreading.acdirican.fiftyshades.worker.WorkPartitioner.Part;

/**
 * Base summer/worker class to calculate the sum of an array.
 * 
 * @author Ahmet Cengizhan Dirican
 * @see https://github.com/acdirican
 */
public class Summer extends Worker {
	protected long sum;
	public Summer(int[] data, Part part) {
		super(data, part);
	}
	public long getSum() {
		return sum;
	}

}

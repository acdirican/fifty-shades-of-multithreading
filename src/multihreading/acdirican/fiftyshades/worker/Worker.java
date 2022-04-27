package multihreading.acdirican.fiftyshades.worker;

import multihreading.acdirican.fiftyshades.worker.WorkPartitioner.Part;

/**
 * Base worker class for an array.
 * 
 * @author Ahmet Cengizhan Dirican
 * @see https://github.com/acdirican
 */
public abstract class Worker {

	protected final int start;
	protected final int finish;
	protected final int[] data;
	
	public Worker(int[] data, int start, int finish) {
		this.start = start;
		this.finish = finish;
		this.data = data;
	}

	public Worker(int[] data, Part part) {
	    this(data, part.getStart(), part.getFinish());
	}

	public int getStart() {
		return start;
	}

	public int getFinish() {
		return finish;
	}

	public int[] getData() {
		return data;
	}
	
	
}

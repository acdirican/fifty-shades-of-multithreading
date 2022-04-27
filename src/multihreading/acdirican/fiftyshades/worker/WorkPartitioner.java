package multihreading.acdirican.fiftyshades.worker;

import java.util.ArrayList;
import java.util.List;

/**
 * This class paritition  a given work into part. It a calculates the work parts start and finish indexes.
 * 
 * @author Ahmet Cengizhan Dirican
 * @see https://github.com/acdirican
 */
public class WorkPartitioner {
	
	public static List<Part> partitions(int size, int workerCount){
		List<Part> parts =  new ArrayList<>();
		int part = (int) Math.ceil( (double)size / workerCount);
		for (int i = 0; i <workerCount ; i++) {
			int start = i * part;
			int finish = Math.min((i+1) * part, size);
			parts.add(new Part(start, finish));
		}
		return parts;
	}

	public static class Part {
		private final int start;
		private final int finish;
		public Part(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}
		public int getStart() {
			return start;
		}
		public int getFinish() {
			return finish;
		}
	}
}

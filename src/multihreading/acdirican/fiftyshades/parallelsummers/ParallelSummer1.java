package multihreading.acdirican.fiftyshades.parallelsummers;

import java.util.ArrayList;
import java.util.List;

import multihreading.acdirican.fiftyshades.summers.SummerRunnable;
import multihreading.acdirican.fiftyshades.summers.SummerThread;
import multihreading.acdirican.fiftyshades.worker.WorkPartitioner;

/**
 * This class calculates the sum of an array using {@link SummerRunnable} and conventional thread
 * start and join mechanisms placed into {@link SummerRunnable}.
 * 
 * @author Ahmet Cengizhan Dirican
 * @see https://github.com/acdirican
 */
public class ParallelSummer1 {

	public static long sum(int[] data, int threadCount) {
		
		List<SummerRunnable> summers =  new ArrayList<>();
		List<WorkPartitioner.Part> parts =  WorkPartitioner.partitions(data.length, threadCount);
		
		for (WorkPartitioner.Part part : parts) {
			summers.add(new SummerRunnable(data,part));
		}
		
		for (SummerRunnable SummerRunnable : summers) {
			SummerRunnable.startThread();
		}
		
		for (SummerRunnable SummerRunnable : summers) {
			try {
				SummerRunnable.joinThread();
			} catch (InterruptedException e) {
				System.err.println("Thread cannot join!");
			}
		}
		
	    long sum = 0;
	    for (SummerRunnable summerRunnable : summers) {
			sum += summerRunnable.getSum();
		}

	    return sum;
	}

	
}

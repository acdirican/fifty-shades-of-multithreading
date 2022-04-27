package multihreading.acdirican.fiftyshades.parallelsummers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import multihreading.acdirican.fiftyshades.summers.SummerCallable;
import multihreading.acdirican.fiftyshades.summers.SummerThread;
import multihreading.acdirican.fiftyshades.worker.WorkPartitioner; 


/**
 * This class calculates the sum of an array using {@link SummerCallable} and {@link ExecutorService} 
 * with a fixed thread  pool. The class invokes all the callables at once.
 * 
 * @author Ahmet Cengizhan Dirican
 * @see https://github.com/acdirican
 */

public class ParallelSummer3 {
	
	public static long sum(int[] data, int threadCount) {
		
		//creating a pool of #threadCount threads  
		ExecutorService executor = Executors.newFixedThreadPool(threadCount);
		
		List<SummerCallable> summers =  new ArrayList<SummerCallable>();
		List<WorkPartitioner.Part> parts =  WorkPartitioner.partitions(data.length, threadCount);
		
		for (WorkPartitioner.Part part : parts) {
			summers.add(new SummerCallable(data,part));
		}
		
		List<Future<Long>> results;
		try {
			results = executor.invokeAll(summers);
		} catch (InterruptedException e) {
			System.err.println("Cannot invoke the threads.");
			return -1;
		}
		
		executor.shutdown();
	    
	    long sum = 0;
	    for (Future<Long> future : results) {
			try {
				sum += future.get();
			} catch (InterruptedException | ExecutionException e) {
				System.err.println("Cannot get the results from threads.");
				return -2;
			}
		}
	    return sum;
	}

}

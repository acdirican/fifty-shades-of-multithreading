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
 * This class calculates the sum of an array using {@link SummerThread} and {@link ExecutorService} 
 * with a fixed thread  pool. The class submits the threads one bye one for executions.
 * 
 * @author Ahmet Cengizhan Dirican
 * @see https://github.com/acdirican
 */
public class ParallelSummer4{
	
	public static long sum(int[] data, int threadCount) {
		
		//creating a pool of 5 threads  
		ExecutorService executor = Executors.newFixedThreadPool(threadCount);
		List<Future<Long>> results = new ArrayList<Future<Long>>();
		List<WorkPartitioner.Part> parts =  WorkPartitioner.partitions(data.length, threadCount);
		
		for (WorkPartitioner.Part part : parts) {
			results.add(executor.submit(new SummerCallable(data, part)));
		}

		executor.shutdown();
		
		while (!executor.isTerminated()) {
			//System.out.println("Processing...");
		}

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

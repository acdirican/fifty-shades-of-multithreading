package multihreading.acdirican.fiftyshades.parallelsummers;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import multihreading.acdirican.fiftyshades.summers.SummerThread;
import multihreading.acdirican.fiftyshades.worker.WorkPartitioner; 

/**
 * This class calculates the sum of an array using {@link SummerThread} and {@link ExecutorService} 
 * with a fixed thread  pool. The class executes the threads one bye one.
 * 
 * @author Ahmet Cengizhan Dirican
 * @see https://github.com/acdirican
 */
public class ParallelSummer2{

	public static long sum(int[] data, int threadCount) {
		
		List<SummerThread> summers =  new ArrayList<>();
		List<WorkPartitioner.Part> parts =  WorkPartitioner.partitions(data.length, threadCount);
		
		for (WorkPartitioner.Part part : parts) {
			summers.add(new SummerThread(data,part));
		}
		
		//creating a pool of 5 threads  
		ExecutorService executor = Executors.newFixedThreadPool(threadCount);
		
		for (SummerThread summer: summers) {
			executor.execute(summer);
		}
			
		executor.shutdown();
		
		//Waiting for all the thread to finalize
		while (!executor.isTerminated()) {
			//System.out.println("Processing....");
		}  
	   
	    return summers.stream().mapToLong(SummerThread::getSum).sum();
	}

	
}

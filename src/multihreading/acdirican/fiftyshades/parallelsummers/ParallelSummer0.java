package multihreading.acdirican.fiftyshades.parallelsummers;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import multihreading.acdirican.fiftyshades.summers.SummerRunnable;
import multihreading.acdirican.fiftyshades.summers.SummerThread;
import multihreading.acdirican.fiftyshades.worker.WorkPartitioner; 


/**
 * This class calculates the sum of an array using {@link SummerThread} and conventional thread
 * start and join mechanisms.
 * 
 * @author Ahmet Cengizhan Dirican
 * @see https://github.com/acdirican
 */
public class ParallelSummer0{

	public static long sum(int[] data, int threadCount) {
		
		List<SummerThread> summers =  new ArrayList<>();
		List<WorkPartitioner.Part> parts =  WorkPartitioner.partitions(data.length, threadCount);
		
		for (WorkPartitioner.Part part : parts) {
			summers.add(new SummerThread(data,part));
		}
		
		for (SummerThread summerThread : summers) {
			summerThread.start();
		}
		
		for (SummerThread summerThread : summers) {
			try {
				summerThread.join();
			} catch (InterruptedException e) {
				System.err.println("Thread cannot join!");
			}
		}
		
	    
	    int sum = 0;
	    for (SummerThread summerThread : summers) {
			sum += summerThread.getSum();
		}

	    return sum;
	}

	
}

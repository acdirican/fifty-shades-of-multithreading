package multihreading.acdirican.fiftyshades;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.experimental.ParallelComputer;
import org.junit.jupiter.api.BeforeAll;


import multihreading.acdirican.fiftyshades.data.TestData;
import multihreading.acdirican.fiftyshades.parallelsummers.ParallelSummer0;
import multihreading.acdirican.fiftyshades.parallelsummers.ParallelSummer1;
import multihreading.acdirican.fiftyshades.parallelsummers.ParallelSummer2;
import multihreading.acdirican.fiftyshades.parallelsummers.ParallelSummer3;

/**
 * This projects is indented to show different ways of parallel programming in java 
 * in terms of 
 *  # designing workers
 *  # executing them
 *  # getting and combining the results
 * 
 * @author Ahmet Cengizhan Dirican
 * @see https://github.com/acdirican
 */
public class Main {
	public static void main(String[] args) {
		int size = 1000000;
		int[] data = TestData.createData(size);
		long result = SequentialSummer.sum(data);
		int threadCount = 8;
		System.out.println("Sequential summer:" + result);
		System.out.println("Parallel summer 1: " + ParallelSummer0.sum(data, 8));
		System.out.println("Parallel summer 2: " + ParallelSummer1.sum(data, 8));
		System.out.println("Parallel summer 3: " + ParallelSummer2.sum(data, 8));
		System.out.println("Parallel summer 4: " + ParallelSummer3.sum(data, 8));
		
	}
}

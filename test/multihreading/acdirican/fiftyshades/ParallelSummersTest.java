package multihreading.acdirican.fiftyshades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import multihreading.acdirican.fiftyshades.data.TestData;
import multihreading.acdirican.fiftyshades.parallelsummers.ParallelSummer0;
import multihreading.acdirican.fiftyshades.parallelsummers.ParallelSummer1;
import multihreading.acdirican.fiftyshades.parallelsummers.ParallelSummer2;
import multihreading.acdirican.fiftyshades.parallelsummers.ParallelSummer3;
import multihreading.acdirican.fiftyshades.parallelsummers.ParallelSummer4;

class ParallelSummersTest {
	private static int size;
	private static int[] data;
	private static long result;
	
	@BeforeAll
	public static void initialize() {
		size = 1000000;
		data = TestData.createData(size);
		result = SequentialSummer.sum(data);
	}
	
	private static void testAll(int threadCount) {
		assertEquals(result, ParallelSummer0.sum(data,threadCount));
		assertEquals(result, ParallelSummer1.sum(data,threadCount));
		assertEquals(result, ParallelSummer2.sum(data,threadCount));
		assertEquals(result, ParallelSummer3.sum(data,threadCount));
		assertEquals(result, ParallelSummer4.sum(data,threadCount));
	}
	
	@Test
	void testSingleThread() {
		testAll(1);
	}
	
	@Test
	void testTwoThread() {
		testAll(2);
	}
	
	@Test
	void testFourThread() {
		testAll(4);
	}
	
	@Test
	void testEightThread() {
		testAll(8);
	}
	
	@Test
	void testSixteenThread() {
		testAll(16);
	}


}

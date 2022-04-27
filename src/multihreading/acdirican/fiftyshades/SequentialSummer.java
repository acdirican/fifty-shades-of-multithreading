package multihreading.acdirican.fiftyshades
;
/**
 * This class provides a method to sequentially calculate the sum of an array.
 * 
 * @author Ahmet Cengizhan Dirican
 * @see https://github.com/acdirican
 */
public class SequentialSummer {
	/**
	 * Returns the sum of all the element of a given array.
	 * @param data the integer array
	 * @return the sum
	 */
	public static long sum(int[] data) {
		long sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
}

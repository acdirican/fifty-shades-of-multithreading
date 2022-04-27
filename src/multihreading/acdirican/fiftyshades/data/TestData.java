package multihreading.acdirican.fiftyshades.data;

/**
 * This class is to produce necessary test data.
 * 
 * @author Ahmet Cengizhan Dirican
 * @see https://github.com/acdirican
 */
public class TestData {
		
	public static int[] createData(int size) {
		int[] data =  new int[size];
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) (Math.random() * 10);
		}
		return data;
	}
}

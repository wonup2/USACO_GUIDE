import java.util.*;

//binarySearch method
//lower bound
//upper bound


public class BS_BuiltinFunction {

	public static void main(String[] args) {
		
		int[] a = {1,3,4,19,10};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));  //{1,3,4,10,19};
		
		int n = Arrays.binarySearch(a, 4);		//2
		
		n = Arrays.binarySearch(a, 11);   		// -5
		
		int lower = Math.abs(n) - 2;  			//lower bound: 10
		
		int upper = Math.abs(n) - 1;  			//upper bound: 19
		
		

		int[] b = {1,3,4,10,10,19};
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		
		tm.put(1, 0);
		tm.put(3, 1);
		tm.put(4, 2);
		tm.put(10, 3);
		tm.put(19, 5);
		
		lower = tm.lowerKey(11);
		System.out.println(lower);			//10
		System.out.println(tm.get(lower));	//3
		
		upper = tm.higherKey(11);			
		System.out.println(upper);			//19
		System.out.println(tm.get(upper));	//5
	}
}
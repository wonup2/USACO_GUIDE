import java.util.*;

public class Sorting1 {

	public static void main(String[] args) {

		//Array
		int a[] = {3, 1, 2, 20, 14};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		//ArrayList
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(30);
		b.add(130);
		b.add(300);
		b.add(34);
		b.add(34);

		Collections.sort(b);
		System.out.println(b);
		
		//TreeSet
		TreeSet<Integer> c = new TreeSet<Integer>();
		c.add(30);
		c.add(12);
		c.add(20);
		c.add(1);
		c.add(3);
		System.out.println(c);
		
		//TreeMap
		TreeMap<Integer, Integer> d = new TreeMap<Integer, Integer>();
		d.put(30, 100);
		d.put(3, 100);
		d.put(10, 100);
		d.put(100, 100);
		d.put(30, 200);

		System.out.println(d);
	}
	
	

}

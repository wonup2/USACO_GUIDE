import java.util.*;

public class testtest {

	public static void main(String[] args) {

		HashSet<Integer> s1 = new HashSet<Integer>();
		s1.add(100);
		s1.add(10);
		s1.add(20);
		s1.add(10);

		System.out.println(s1);
		
		TreeSet<Integer> s2 = new TreeSet<Integer>();
		s2.add(100);
		s2.add(10);
		s2.add(20);
		s2.add(105);
		s2.add(105);
		s2.add(105);

		System.out.println(s2.first() + s2.last());

		LinkedHashSet<Integer> s3 = new LinkedHashSet<Integer>();
		s3.add(100);
		s3.add(10);
		s3.add(20);
		s3.add(105);
		
		System.out.println(s3);

		
	}

}

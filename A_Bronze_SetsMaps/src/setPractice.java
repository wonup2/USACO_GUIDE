import java.util.*;

public class setPractice {

	public static void main(String[] args) {

		HashSet<Integer> s1 = new HashSet<Integer>();
		s1.add(1);
		s1.add(10);
		s1.add(110);
		s1.add(21);
		s1.add(301);
		
		System.out.println(s1);
		
		//for(int n: s1)
		//	System.out.println(n);
		
		TreeSet<Integer> s2 = new TreeSet<Integer>();
		s2.add(1);
		s2.add(10);
		s2.add(110);
		s2.add(21);
		s2.add(301);
		
		System.out.println(s2);
		//System.out.println(s2.first()+" "+s2.last());
		
		int i=0;
		/*
		for(int n:s2) {
			if(i%2==0) { 
				System.out.print(n+" "); 
			}
			i++;		
		}*/

		LinkedHashSet<Integer> s3 = new LinkedHashSet<Integer>();
		s3.add(1);
		s3.add(10);
		s3.add(110);
		s3.add(21);
		s3.add(301);
		System.out.println(s3);
		
	}
}



import java.util.*;

public class ArrayList_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		a.add(10);
		a.add(20);
		a.add(30);
		
		System.out.println(a);
		System.out.println(a.size());
		
		a.add(0, 100);
		
		System.out.println(a);
		
		Collections.sort(a);
		System.out.println(a);
				
		System.out.println(a.get(2));
		
		a.remove(2); 		System.out.println(a);

		
		ArrayList<String> s = new ArrayList<String>();
		s.add("Hello");
		s.add("Java");
		s.add("Taeyeon");
		System.out.println(s);
		s.remove("Java"); System.out.println(s);


	}

}

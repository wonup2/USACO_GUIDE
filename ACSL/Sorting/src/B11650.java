import java.util.*;

public class B11650 {
	
	static Scanner in;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		int n = in.nextInt();  //5
		
		pair a[] = new pair[n];
		
		for(int i=0; i<n; i++)
			a[i] = new pair(in.nextInt(), in.nextInt());
	
		Arrays.sort(a);
		
		for(int i=0; i<n; i++) System.out.println(a[i].toSring());	
		
	}

	static class pair implements Comparable<pair>{
		
		//data field
		int x;
		int y;
		
		//constructor
		pair(int a, int b){
			x = a;
			y = b;
		}	
		
		public String toSring() {
			return x +" "+y;
		}

		@Override
		public int compareTo(B11650.pair that) {
			
			if(this.x == that.x)			
				return this.y - that.y;			
			
			return this.x - that.x;
		}
	}
}

/*
5
3 4
1 1
1 -1
2 2
3 3

*/

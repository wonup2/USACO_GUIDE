import java.util.*;

public class B10825 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		report a[] = new report[n];
		
		//input
		for(int i=0; i<n; i++) 
			a[i] = new report(in.next(), in.nextInt(), in.nextInt(), in.nextInt());
		
		Arrays.sort(a);
		
		//output
		for(int i=0; i<n; i++)
			System.out.println(a[i].name);
	}

	
	static class report implements Comparable<report>{

		//data field
		String name;
		int korean;
		int english;
		int math;
		
		//constructor
		report(String n, int k, int e, int m){
			name = n;
			korean = k;
			english = e;
			math = m;
		}
		
		public String toString() {
			return name+" "+korean+" "+english+" "+math;
		}
		
		@Override
		public int compareTo(report that) {

			if(this.korean==that.korean) {
				
				if(this.english == that.english) 					
					
					if(this.math == that.math)
						return this.name.compareTo(that.name);
				
					else return that.math-this.math;				
				
				else return this.english-that.english;
				
			}			
			else return that.korean - this.korean;
		}		
	}
}

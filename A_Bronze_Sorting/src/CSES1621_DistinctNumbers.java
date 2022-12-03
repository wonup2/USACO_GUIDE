import java.io.*;
import java.util.*;
 
public class CSES1621_DistinctNumbers {
 
	
	public static void main(String[] args) throws IOException {
 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		StringTokenizer st = new StringTokenizer(in.readLine());  //2 3 2 2 3
		
		for(int i=0; i<n; i++) {
			
			int temp = Integer.parseInt(st.nextToken());
			set.add(temp);
			
		}
			
		System.out.println(set.size());		
		
	}
 
}
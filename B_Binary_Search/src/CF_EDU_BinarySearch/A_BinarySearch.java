package CF_EDU_BinarySearch;
import java.io.*;
import java.util.*;

public class A_BinarySearch {	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		int n=Integer.parseInt(st.nextToken()); 
		int m=Integer.parseInt(st.nextToken()); 		
		int[] a=new int[n]; 
		st=new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		st=new StringTokenizer(in.readLine());
		while(m-->0) {
			int s = Arrays.binarySearch(a, Integer.parseInt(st.nextToken()));
			if(s>=0) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
				
		System.out.print(sb.toString());
		in.close();
	}
}

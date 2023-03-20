package CF_EDU_BinarySearch;
//https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/A
import java.io.*;
import java.util.*;

public class A_BinarySearch {	
	static BufferedReader in;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));		
		st=new StringTokenizer(in.readLine());
		
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

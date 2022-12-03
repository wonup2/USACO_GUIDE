import java.util.*;
import java.io.*;
 
public class CF863B_Kayaking{
 
	static BufferedReader in;
	static StringTokenizer st;
 
	static int n, a[], ans;
 
	public static void main(String[] args) throws IOException {
 
		in = new BufferedReader(new InputStreamReader(System.in));
					
		n = Integer.parseInt(in.readLine())*2;
		a = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(st.nextToken());		
	    
 
	    int m=Integer.MAX_VALUE;
	    int sum=0;
	    for(int i=0;i<n-1;i++){
	        for(int j=i+1;j<n;j++){
	            sum=0;
	            ArrayList <Integer>v = new ArrayList<Integer>();
	            for(int k=0;k<n;k++) {
	                if(k!=j && k!=i)
	                    v.add(a[k]);
	            }
	            Collections.sort(v);
	            for(int k=0;k<v.size();k+=2)
	                sum+=(v.get(k+1)-v.get(k));
 
	            m=Math.min(m,sum);
	        }
	    }
 
 
	    System.out.println(m);
 
	}
}
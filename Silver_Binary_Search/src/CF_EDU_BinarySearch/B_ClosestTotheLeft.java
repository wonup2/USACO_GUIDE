package CF_EDU_BinarySearch;

import java.io.*;
import java.util.*;
 
public class B_ClosestTotheLeft{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
 
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> a = new TreeMap<Integer, Integer>();
                
        st = new StringTokenizer(in.readLine());
        
        for(int i=1; i<=n; i++) {
        	int t=Integer.parseInt(st.nextToken());
        	a.put(t, i);
        }
		StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<m; i++) {
        	int key = Integer.parseInt(st.nextToken());
        	if(a.containsKey(key)) sb.append(a.get(key));
        	else if(a.lowerKey(key)!=null) sb.append(a.get(a.lowerKey(key)));
        	else sb.append(0);
        	sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
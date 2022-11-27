package CF_EDU_BinarySearch;
//https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/D

import java.io.*;
import java.util.*;
 
public class D_FastSearch{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
 
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        
        TreeMap<Integer, Integer> a = new TreeMap<Integer, Integer>(); 
        for(int i=0; i<n; i++)a.put(arr[i], i+1);
               
        //System.out.println(a);        
        
        int m = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(in.readLine());

        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	
        	if(a.containsKey(s)) s = a.get(s);
        	else s = a.higherKey(s);
        	if(a.containsKey(e)) e = a.get(e);
        	else {
        		e = a.lowerKey(e)==null? -1: a.lowerKey(e);
        	}
        	
        	int ans = e-s+1;
        	if(ans<0) ans = 0;
        	sb.append(ans).append("\n");
        }
        
        System.out.print(sb);
    }
}
package CF_EDU_BinarySearch;
//https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/B
import java.io.*;
import java.util.*;
 
public class B_ClosestTotheLeft{
	
	static BufferedReader in;
	static StringTokenizer st;
	
	static int n, k;
	static TreeMap<Integer, Integer> a;
	
    public static void main(String[] args) throws NumberFormatException, IOException{
        in = new BufferedReader(new InputStreamReader(System.in));        
 
        init();
        solve();
    }
    
    static void init() throws IOException {
    	
    	st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        a = new TreeMap<Integer, Integer>();
                
        st = new StringTokenizer(in.readLine());
        
        for(int i=1; i<=n; i++) {
        	int t=Integer.parseInt(st.nextToken());
        	a.put(t, i);
        }
        
        //System.out.println(a);
    }
    
    static void solve() throws IOException {
                
		StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<k; i++) {
        	int key = Integer.parseInt(st.nextToken());
        	if(a.containsKey(key)) sb.append(a.get(key));
        	else if(a.lowerKey(key)!=null) sb.append(a.get(a.lowerKey(key)));
        	else sb.append(0);
        	sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
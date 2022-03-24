import java.util.*;
import java.io.*;

public class stacking {

    static BufferedReader in;
    static StringTokenizer st;
    static PrintWriter out;
    static String filename = "stacking";
    static int n, k, p[], a, b;
    
    public static void main(String[] args) throws IOException {

        in = new BufferedReader(new FileReader(filename+".in"));
        out = new PrintWriter(new File(filename+".out")); 
        init();
        solve();
        
        in.close();
        out.close();
    }
    
    static void init() throws IOException {    
        st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());        
        p = new int[n+1];
    }
    
    static void solve() throws IOException {
    	
    	for(int i=0; i<k; i++) fill();
    	for(int i=1; i<=n; i++) p[i] += p[i-1];
    	Arrays.sort(p);
    	out.println(p[n/2+1]);

    }
    
    static void fill() throws IOException {
        st = new StringTokenizer(in.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken()); 
        
        p[a-1]++;
        p[b]--;
    }

}
import java.util.*;
import java.io.*;
 
public class CSES1640_SumofTwoValues {
 
    static BufferedReader in;
    static StringTokenizer st;
    static int n, x;
    static HashMap<Integer, Integer> m;
    
    public static void main(String[] args) throws IOException {
 
        in = new BufferedReader(new InputStreamReader(System.in));
        init();
        solve();
        in.close();
 
    }
    
    static void init() throws IOException {
        st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());        
        m = new HashMap<Integer, Integer>();
    }
    
    static void solve() throws IOException {
    	
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<n; i++) {
        	int num = Integer.parseInt(st.nextToken()); 
            int val = x - num;
            if(m.containsKey(val)) {
                System.out.println(m.get(val) + " " + (i+1));
                return;
            }
            else m.put(num, i+1);
        }
        System.out.println( "IMPOSSIBLE" );
    }
}
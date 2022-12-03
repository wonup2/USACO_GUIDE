import java.util.*;
import java.io.*;
 
public class CSES1640_SumofTwoValues {
 
    static BufferedReader in;
    static StringTokenizer st;
    static int n, x, a[];
    static HashMap<Integer, Integer> m;
    
    public static void main(String[] args) throws IOException {
 
        in = new BufferedReader(new InputStreamReader(System.in));
        init();
        System.out.println(solve());
        in.close();
 
    }
    
    static void init() throws IOException {
        st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<n; i++) {
          a[i] = Integer.parseInt(st.nextToken());
        }
        m = new HashMap<Integer, Integer>();
    }
    static String solve() {
        for(int i=0; i<a.length; i++) {
            int val = x-a[i];
            if(m.containsKey(val)) {
                return (i+1) + " " + m.get(val);
            }
            else m.put(a[i], i+1);
        }
        return "IMPOSSIBLE";
    }
}
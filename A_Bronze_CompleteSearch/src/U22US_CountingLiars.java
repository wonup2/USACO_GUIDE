import java.io.*;
import java.util.*;


public class U22US_CountingLiars {
	static BufferedReader in;
	static StringTokenizer st;
	static int n, p[];
	static char s[];
	
    public static void main(String[] args) throws IOException {
    	
        in = new BufferedReader(new InputStreamReader(System.in));
      
        init();
        solve();
    }
    
    static void init() throws NumberFormatException, IOException {
        n = Integer.parseInt(in.readLine());
        s = new char[n];
        p = new int[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            s[i] = st.nextToken().charAt(0);
            p[i] = Integer.parseInt(st.nextToken());
        }       
    }
        
    static void solve() {
    	
    	int answer = n;
    	
        for (int i = 0; i < n; i++) {
            int x = p[i];
            int liars = 0;
            
            for (int j = 0; j < n; j++) 
                if (s[j] == 'G' && x < p[j] || s[j] == 'L' && x > p[j]) liars++;
            
            answer = Math.min(answer, liars);
        }
        System.out.println(answer);     
    }
    
}
import java.util.*;
import java.io.*;

public class lazy {

    static BufferedReader in;
    static StringTokenizer st;

    static PrintWriter out;
    static String filename = "lazy";
    static int n, k, a[][], p[][];
    
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
        a = new int[n+4][n+4];
        p = new int[n+4][n+4];
        for(int i=2; i<n+2; i++) {
            st = new StringTokenizer(in.readLine());
        	for(int j=2; j<n+2; j++) {
        		a[i][j] = Integer.parseInt(st.nextToken());        		
        	}               
        }
                
        for(int i=1; i<n+4; i++) {
        	for(int j=1; j<n+4; j++) {
        		p[i][j] = a[i][j]+p[i-1][j]+p[i][j-1]-p[i-1][j-1];        		
        	} System.out.println(Arrays.toString(p[i]));
        }
        
    }
    
    static void solve() throws IOException {
    	
    	int max = 0;
    	int sum = 0; 
    	for(int i=2; i<n+4; i++) {
          	for(int j=2; j<n+4; j++) {
          		sum= a[i-1][j]+a[i][j-1]-a[i-1][j-1];        		
          	} System.out.println(Arrays.toString(a[i]));
          }
    }

}
import java.util.*;
import java.io.*;

public class shell {

    static Scanner in;
    static PrintWriter out;
    static String filename = "shell";
    static int n, a[], b[], g[], s[], max;
    
    public static void main(String[] args) throws IOException {

        in = new Scanner(new File(filename+".in"));        
        out = new PrintWriter(new File(filename+".out")); 
        init();
        solve();        
        in.close();
        out.close();
    }
    
    static void init() throws IOException {    

    	n= in.nextInt();
    	a = new int[n];
    	b = new int[n];
    	g = new int[n];
    	for(int i=0; i<n; i++) {
    		a[i] = in.nextInt() - 1;
    		b[i] = in.nextInt() - 1;
    		g[i] = in.nextInt() - 1;
    	}
    }
    
    static void solve() throws IOException {
    	
    	s = new int[]{1,0,0};
    	max = game();
    	
    	s = new int[]{0,1,0};
    	max = Math.max(max, game());

    	s = new int[]{0,0,1};
    	max = Math.max(max, game());
    	
    	out.println(max);
    }

    static int game() {
    	
    	int score =0;
    	for(int i=0; i<n; i++) {
    		int x = s[a[i]];
    		int y = s[b[i]];
    		s[a[i]] = y;
    		s[b[i]] = x;
    		
    		if(s[g[i]] == 1) score++;
    	}
    	
    	return score;
    }
}
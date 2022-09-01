import java.io.*;
import java.util.*;
public class U20Feb_Triangles {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static TreeSet<Integer> setX, setY;
    static int x[], y[], n;
	
    public static void main(String[] args) throws IOException {
	    in = new BufferedReader(new FileReader("test.in"));
	    out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
	    
	    init();
	    solve();
	    
	    in.close();
	    out.close();
    }
  
  	static void init() throws NumberFormatException, IOException {
	    n = Integer.parseInt(in.readLine());
	    x = new int[n];
	    y = new int[n];
	    
	    for(int i=0; i<n; i++) {
	    	st = new StringTokenizer(in.readLine());
	    	x[i] = Integer.parseInt(st.nextToken());
	    	y[i] = Integer.parseInt(st.nextToken());

	    }
	   
  	}
  
  	static void solve() {
  		
  		int ans = 0;
  		
  		for(int i=0; i<n; i++) {
  			for(int j=0; j<n; j++) {
  				for(int k=0; k<n; k++) {
  					if(check(i, j, k)) {
  						
  						int area = (setX.last()-setX.first()) * (setY.last()-setY.first());
  						ans = Math.max(ans, area);
  						
  					}
  				}
  			}
  		}
  		
  		System.out.println(ans);
  	}
  
	static boolean check(int i, int j, int k) {	  
	
		setX = new TreeSet<Integer> ();
		setY = new TreeSet<Integer> ();
		
		setX.add(x[i]);		setX.add(x[j]);		setX.add(x[k]);

		setY.add(y[i]);		setY.add(y[j]);		setY.add(y[k]);
		
		return setX.size()==2 && setY.size()==2;
		
	}
}


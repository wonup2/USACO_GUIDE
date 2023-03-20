import java.io.*;
import java.util.*;
public class U20Feb_Triangles {
	
	static BufferedReader in;
	static PrintWriter out;
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
	    
	    for(int i = 0; i < n; i++) {
	      StringTokenizer st = new StringTokenizer(in.readLine());
	      x[i] = Integer.parseInt(st.nextToken());
	      y[i] = Integer.parseInt(st.nextToken());
	    }	        	    
	    setX = new TreeSet<Integer>();
	    setY = new TreeSet<Integer>();
  	}
  
  	static void solve() {
  		int area = 0;

	  	for(int i = 0; i < n-2; i++) 
	      for(int j = i+1; j < n-1; j++) 
	        for(int k = j+1; k < n; k++)          	
	        	if(ok(i, j, k)) 
	        		area = Math.max(area, (setX.last()-setX.first()) * (setY.last()-setY.first()));
	        	
	    out.println(area);
    
  	}
  
	static boolean ok(int i, int j, int k) {	  
		setX.clear(); setY.clear();
		setX.add(x[i]);setX.add(x[j]);setX.add(x[k]);
		setY.add(y[i]);setY.add(y[j]);setY.add(y[k]);
			  
		return setX.size() == 2 && setY.size() == 2;
	}
}



/*
for(int i = 0; i < n; i++) {
for(int j = 0; j < n; j++) { // same x-coordinate
  if(i == j || x[i] != x[j]) continue;
  for(int k = 0; k < n; k++) { // same y-coordinate
    if(i == k || y[i] != y[k]) continue;
    ret = Math.max(ret, Math.abs(x[k] - x[i]) * Math.abs(y[j] - y[i]));
  }
}
*/
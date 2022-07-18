import java.util.*;
import java.io.*;

public class U17BDec_measurement {

    static Scanner in;
    static PrintWriter out;
    static String filename = "test";
    
    static int n, milk[], change;
    static boolean cur[], next[];
    static TreeMap<Integer, int[]> a;
        
    public static void main(String[] args) throws IOException {

        in = new Scanner(new File(filename+".in"));        
        out = new PrintWriter(new File(filename+".out")); 
        init();
        solve();
        
        in.close();
        out.close();
    }
    
    static void init() throws IOException {    

    	n = in.nextInt();
    	a = new TreeMap<Integer, int[]>();
    	
    	for(int i=0; i<n; i++) 
    		a.put(in.nextInt(), new int[] {conv(in.next()), in.nextInt()});
	    	
    	milk = new int[] {7,7,7};
    	cur = new boolean[] {true, true, true};
    	next = new boolean[3];
    	change = 0;
    }
    
    static void solve() throws IOException {
    	
    	int max = 0;
    	
    	for(int d : a.keySet()) {
    		
    		int idx = a.get(d)[0];
    		int m = a.get(d)[1];
    		
    		milk[idx] += m;
    		
    		max = Math.max(milk[0], Math.max(milk[1], milk[2]));
    		
    		for(int j=0; j<3; j++) 
    			if(milk[j]==max) next[j] = true;
    		
    		if(!Arrays.equals(cur, next)) change++;
    		
    		cur = next.clone();
    		next = new boolean[3];
    	}
    	
    	out.println(change);
    }
    
    static int conv(String s) {
    	if(s.equals("Elsie")) return 0;
    	else if(s.equals("Mildred")) return 1;
    	return 2;
    }

}
import java.util.*;
import java.io.*;

public class measurement {

    static Scanner in;
    static PrintWriter out;
    static String filename = "measurement";
    
    static int n, milk[], change;
    static boolean cur[], next[];
    static data a[];
    
    static class data implements Comparable<data>{
    	int date;
    	String name;
    	int milk;
    	
    	data(int d, String n, int m){
    		date = d;
    		name = n;
    		milk = m;
    	}
    	
    	public String toString() {
    		return date + " " + name + " " + milk;
    	}

		@Override
		public int compareTo(measurement.data that) {

			if(this.date < that.date) return -1;
			else return 1;
		}
    }
    
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
    	a = new data[n];
    	
    	for(int i=0; i<n; i++) a[i] = new data(in.nextInt(), in.next(), in.nextInt());
    	
    	Arrays.sort(a);    	
    	
    	milk = new int[] {7,7,7};
    	cur = new boolean[] {true, true, true};
    	next = new boolean[3];
    	change = 0;
    }
    
    static void solve() throws IOException {
    	
    	int max = 0;
    	
    	for(int i=0; i<n; i++) {
    		
    		int idx = conv(a[i].name);
    		int m = a[i].milk;
    		
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
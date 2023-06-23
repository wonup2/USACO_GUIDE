import java.util.*;
import java.io.*;

public class measurement {

    static Scanner in;
    
    static PrintWriter out;

    static String f = "test";
    static int n;
    static triple a[];

    static class triple implements Comparable<triple>{
        
        int day, cow, milk;
        triple(int d, int c, int m){
            day = d;
            cow = c;
            milk = m;
        }
        
        public int compareTo(triple that) {
            return this.day - that.day;
        }
        
        public String toString() {
            return day+" "+cow+" "+milk;
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        in = new Scanner(new FileReader(f+".in"));
        out = new PrintWriter(new FileWriter(f+".out"));
        init();
        solve();
        
        in.close();
        out.close();
    }
    
    static void init() throws IOException {
        n = in.nextInt();
        
        a = new triple[n];
        
        for(int i=0; i<n; i++) {
            int day = in.nextInt();
            int cow = convert(in.next());
            int milk = in.nextInt();
            a[i] = new triple(day, cow, milk);            
        }
        
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));        
    }
    
    static int convert(String c) {
        if(c.equals("Bessie")) return 0;
        else if (c.equals("Elsie")) return 1;
        else return 2;
    }
    
    
    static void solve() {
        
    	int milk[] = {7, 7, 7};
    	boolean board[] = {true, true, true};
    	boolean cur[] = {false, false, false};
    	
    	int ans = 0;
    	
    	
    	for(triple t: a) {
    		
    		milk[t.cow] += t.milk;
    		int maxMilk = Math.max(milk[0],Math.max(milk[1], milk[2]));
    		
    		for(int i=0; i<3; i++) 
    			if(milk[i] == maxMilk) cur[i] = true; 
    		
    		
    		if(!Arrays.equals(board, cur)) {
    			ans++;
    			board = cur.clone();
    		}
    		
    		cur = new boolean[3];
    	}
    	
    	out.println(ans);
    }

}
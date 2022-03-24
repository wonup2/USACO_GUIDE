import java.util.*;
import java.io.*;

public class blocks {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;
    static String filename = "blocks";
    static int n, a[], b[], c[];
    
    public static void main(String[] args) throws IOException {

        in = new BufferedReader(new FileReader(filename+".in"));        
        out = new PrintWriter(new File(filename+".out")); 
        init();
        solve();        
        in.close();
        out.close();
    }
    
    static void init() throws IOException {    

    	n = Integer.parseInt(in.readLine());
    	a = new int[26];
    	b = new int[26];
    	c = new int[26];
    	
    }
    
    static void solve() throws IOException {
    	
    	String x="", y="";
    	int index = 0;
    	
    	while(n-->0) {
        	a = new int[26];
        	b = new int[26];
        	st = new StringTokenizer(in.readLine());
    		x = st.nextToken().toString();
    		y = st.nextToken().toString();
    		
    		for(int i=0; i<x.length(); i++) {
    			index = x.charAt(i) - 'a';
    			a[index]++;
    		}
    		
    		for(int i=0; i<y.length(); i++) {
    			index = y.charAt(i) - 'a';
    			b[index]++;
    		}
    		
    		for(int i=0; i<26; i++) {
    			c[i] += Math.max(a[i], b[i]);
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i: c)
    		sb.append(i).append("\n");
    	
    	out.print(sb.toString());
    }

}
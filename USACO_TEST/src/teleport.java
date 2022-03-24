import java.util.*;
import java.io.*;

public class teleport {

    static Scanner in;

    static PrintWriter out;
    static String filename = "teleport";
    static int a, b, x, y, ans;
    
    public static void main(String[] args) throws IOException {

        in = new Scanner(new File(filename+".in"));        
        out = new PrintWriter(new File(filename+".out")); 
        init();
        solve();
        
        in.close();
        out.close();
    }
    
    static void init() throws IOException {    

    	a = in.nextInt();
    	b = in.nextInt();
    	x = in.nextInt();
    	y = in.nextInt();
    	ans = 0;
    }
    
    static void solve() throws IOException {
    	
    	
    }

}
import java.util.*;
import java.io.*;

public class bronze2017 {

    static Scanner in;
    static PrintWriter out;
    static String filename = "billboard";
    static boolean space[][];
    static int x1,y1,x2,y2, area;

    public static void main(String[] args) throws IOException {

        in = new Scanner(new File(filename+".in"));
        out = new PrintWriter(new File(filename+".out")); 
        init();
        solve();

        in.close();
        out.close();
    }

    static void init() throws IOException {
        space = new boolean[2001][2001]; // default false
    }

    static void solve() throws IOException {        
    	billboard();        
    	billboard();
        truck();
        out.println(area);
    }
    
    static void billboard() {
    	x1 = in.nextInt()+1000; // keeps within space (-1000,1000)
        y1 = in.nextInt()+1000;
        x2 = in.nextInt()+1000;
        y2 = in.nextInt()+1000;
    	for(int i = x1; i < x2; i++) {
            for(int j = y1; j < y2; j++) {
            	if(!space[i][j]) area ++;
                space[i][j] = true;                 
            }
        }
    }

    static void truck() {
    	x1 = in.nextInt()+1000; // keeps within space (-1000,1000)
        y1 = in.nextInt()+1000;
        x2 = in.nextInt()+1000;
        y2 = in.nextInt()+1000;
        for(int i = x1; i < x2; i++) {
            for(int j = y1; j < y2; j++) {
            	if(space[i][j]) area--;
            }
        }
    }
}
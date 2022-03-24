import java.util.*;
import java.io.*;

public class _Template_old_USACO {

    static Scanner in;
    //static BufferedReader in;
    //static StringTokenizer st;

    static PrintWriter out;
    static String filename = "xxx";
    static int n;
    
    public static void main(String[] args) throws IOException {

        in = new Scanner(new File(filename+".in"));        
        //in = new BufferedReader(new FileReader(filename+".in"));
        out = new PrintWriter(new File(filename+".out")); 
        init();
        solve();
        
        in.close();
        out.close();
    }
    
    static void init() throws IOException {    
        //st = new StringTokenizer(in.readLine());

    }
    
    static void solve() throws IOException {
    }

}
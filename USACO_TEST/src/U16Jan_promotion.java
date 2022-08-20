import java.util.*;
import java.io.*;

public class U16Jan_promotion {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;    
    static String f = "test";
    static int Ob,Nb,Os,Ns,Og,Ng,Op,Np;
    static String b,s,g,p;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new FileReader(f+".in"));
        out = new PrintWriter(new FileWriter(f+".out"));
        init();
        solve();
        
        in.close();
        out.close();
    }
    
    static void init() throws IOException {
    	
    	st = new StringTokenizer(in.readLine());
    	Ob = Integer.parseInt(st.nextToken());
    	Nb = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(in.readLine());
    	Os = Integer.parseInt(st.nextToken());
    	Ns = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(in.readLine());
    	Og = Integer.parseInt(st.nextToken());
    	Ng = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(in.readLine());
    	Op = Integer.parseInt(st.nextToken());
    	Np = Integer.parseInt(st.nextToken());
    	
    	//System.out.println(Ob+" "+Nb+" "+Os+" "+Ns+" "+Og+" "+Ng+" "+Op+" "+Np);
    }
    
    static void solve() {
        int gp = Np-Op;
        int sg = Ng-Og+gp;
        int bs = Ns-Os+Ng-Og+gp;
        out.println(bs);
        out.println(sg);
        out.println(gp);
    }
}
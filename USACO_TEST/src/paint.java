import java.util.*;
import java.io.*;

public class paint {

	static Scanner in;
	static PrintWriter out;
	static String filename = "paint";
	static int a, b, c, d;
	static boolean f[];
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("paint.in"));		
		out = new PrintWriter(new File("paint.out")); 
		init();
		solve();		
		in.close();
		out.close();
		
	}
	
	static void init() throws IOException {	
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();	
		f = new boolean[101];
	}
	
	static void solve() throws IOException {
		
		for(int i=a; i<b; i++) f[i] = true;  //100
		 
		for(int i=c; i<d; i++) f[i] = true;  //100
		
		int ans = 0;

		for(int i=0; i<=100; i++) if(f[i]) ans++;	//100
		
		out.println(ans);
	}
}

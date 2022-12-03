import java.util.*;
import java.io.*;

public class U19BJan_Shell {

	static Scanner in;
	static PrintWriter out;
	static int n, a[], b[], c[], point, max;
	static boolean shell[];
	
	public static void main(String[] args) throws IOException {

		//in = new Scanner(System.in);
		in = new Scanner(new File("shell.in"));
		out = new PrintWriter(new File("shell.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		
		n = in.nextInt();
		a = new int[n];
		b = new int[n];
		c = new int[n];

		for(int i=0; i<n; i++) {
			a[i] = in.nextInt()-1;
			b[i] = in.nextInt()-1;
			c[i] = in.nextInt()-1;
		}
	}
	
	static void solve() {
		
		for(int i=0; i<3; i++) {
			point = 0;
			shell = new boolean[3];
			shell[i] = true;
			game();
			max = Math.max(max, point);
		}

		System.out.println(max);
		out.println(max);
	}
	
	static void game() {
		for(int i=0; i<n; i++) {
			boolean temp = shell[a[i]];
			shell[a[i]] = shell[b[i]];
			shell[b[i]] = temp;
			
			if(shell[c[i]]) point++;
		}
	}
}

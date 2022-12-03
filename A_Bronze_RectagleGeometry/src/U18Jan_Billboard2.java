import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class U18Jan_Billboard2 {
	
	static Scanner in;
	static PrintWriter out;
	static boolean a[][];
	static int x1, y1, x2, y2, cnt;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("billboard.in"));
		out = new PrintWriter(new File("billboard.out"));
		init();	
		in.close();
		out.close();
	}

	static void init() {
		a = new boolean[2001][2001];
		
		b(true);
		b(false);
		c();
	}
	
	static void b(boolean t) {
		
		x1 = in.nextInt() + 1000;
		y1 = in.nextInt() + 1000;
		x2 = in.nextInt() + 1000;
		y2 = in.nextInt() + 1000;
		
		for(int i=x1; i<x2; i++) {
			for(int j=y1; j<y2; j++) {
				a[i][j] = t;			
			}
		}
	}
	
	static void c() {
		
		x1=y1=2000;
		x2=y2=0;
		boolean flag = false;
		
		for(int i=0; i<=2000; i++) {
			for(int j=0; j<=2000; j++) {
				if(a[i][j]) {
					x1 = Math.min(x1, i);
					y1 = Math.min(y1, j);
					x2 = Math.max(x2, i);
					y2 = Math.max(y2, j);
					flag = true;
				}
			}
		}
		
		if(flag) out.println((x2-x1+1)*(y2-y1+1));
		else out.println(0);
	}
}

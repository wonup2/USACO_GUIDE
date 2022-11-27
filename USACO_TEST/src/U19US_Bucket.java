import java.util.*;
import java.io.*;

public class U19US_Bucket {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static String[] a;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		a = new String[10];
		for(int i=0; i<10; i++)
			a[i] = in.readLine();
		
//		System.out.println(Arrays.deepToString(a));
	}
	
	static void solve() {
		
		int bx=0, by=0, rx=0, ry=0, lx=0, ly=0;
		
		for(int i=0; i<10; i++) {
			if(a[i].contains("B")) {
				bx = i;
				by = a[i].indexOf("B");
			}
			if(a[i].contains("R")) {
				rx = i;
				ry = a[i].indexOf("R");
			}
			if(a[i].contains("L")) {
				lx = i;
				ly = a[i].indexOf("L");
			}
		}
		
//		System.out.println(bx+" "+by);
//		System.out.println(rx+" "+ry);
//		System.out.println(lx+" "+ly);

		int ans = Math.abs(bx-lx) + Math.abs(by-ly) - 1;  
		
		if(by==ry && ry==ly) {
			if(bx < rx && rx < lx || lx < rx && rx < bx ) {
				ans += 2;
			}
		}
		else if(bx==rx && rx==lx) {
			if(by < ry && ry < ly || ly < ry && ry < by ) {
				ans += 2;
			}
		}				
		
		out.println(ans);
	}

}
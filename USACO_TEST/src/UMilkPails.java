import java.io.*;
import java.util.Scanner;
public class UMilkPails {
	
	static String file = "test";
	static Scanner in;
	static PrintWriter out;
	static int x, y, m, sum, temp;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File(file + ".in"));
		out = new PrintWriter(new File(file + ".out"));
		
		init();
		solve();
		
		in.close();
		out.close();


	}
	
	static void init() {
		
		x = in.nextInt();
		y = in.nextInt();
		m = in.nextInt();
	}
	
	static void solve() {
		
		for(int i = 0; i<=m/x; i++) {
			for(int j = 0; j<=m/y; j++) {
				
				temp = x*i + y*j;
				if(temp<=m)
					sum = Math.max(sum, temp);
			}
			
		}
		
		out.println(sum);
		
		
	}
	



}
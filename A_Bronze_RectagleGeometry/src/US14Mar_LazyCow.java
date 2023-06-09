import java.io.*;
import java.util.*;


public class US14Mar_LazyCow{
	
	static Scanner in;
	static PrintWriter out;
	static int n, k, a[][], p[][];
	public static void main (String args[]) throws IOException	{
		US14Mar_LazyCow ps = new US14Mar_LazyCow();
		ps.run();
		
	}
	
	public void run() throws IOException {
		in = new Scanner(new File("lazy.in"));
		out = new PrintWriter(new File("lazy.out"));
		n = in.nextInt();
		k = in.nextInt();
		
		//store rotated matrix
		a = new int[2*n][2*n];
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < n; j++) 
				a[i+j+1][n-i+j] = in.nextInt(); 
		
		
		//calculate prefix sums with rotated matrix 
		p = new int[2*n+1][2*n+1];
		for (int i = 1; i < 2*n; i++) 
			for (int j = 1; j < 2*n; j++) 
				p[i][j] = a[i][j] + p[i-1][j] + p[i][j-1] - p[i-1][j-1];
		
		
		//calculate the best position with the highest prefix sum  
		int best = 0; 
		for (int i = 1; i+2*k+1 < 2*n+1; i++) 
			for (int j = 1; j+2*k+1 < 2*n+1; j++) {
				int sum = p[i+2*k+1][j+2*k+1] + p[i][j] - p[i][j+2*k+1] - p[i+2*k+1][j];
				best = Math.max(best, sum);
			}
		
		out.println(best);
		out.close();
	}
}
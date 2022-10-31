import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class UShellGame {
	
	static String file = "test";
	static Scanner in;
	static PrintWriter out;
	static int n, a, b, g, count, ans;
	static int[][] nums;
	static boolean[] shells;
	

	public static void main(String[] args) throws FileNotFoundException {
		
		in = new Scanner(new File(file + ".in"));
		out = new PrintWriter(new File(file + ".out"));
		
		init();
		solve();
		
		in.close();
		out.close();

	}
	
	static void init() {
		
		n = in.nextInt(); in.nextLine();
		nums = new int[n][3];
		for(int j = 0; j<n; j++) {
			nums[j][0] = in.nextInt() - 1;
			nums[j][1] = in.nextInt() - 1;
			nums[j][2] = in.nextInt() - 1;
		}
		
		System.out.println(Arrays.deepToString(nums));		
		
		shells = new boolean[3];
		ans = 0;
		count = 0;
	}
	
	static void solve() {
		
		for(int i = 0; i<3; i++) {
			
			shells = new boolean[3];
			shells[i] = true;					
			
			for(int j=0; j<n; j++) {
				a = nums[j][0];
				b = nums[j][1];
				g = nums[j][2];
				
				boolean temp = shells[a];
				shells[a] = shells[b];
				shells[b] = temp;
								
				if(shells[g]) count++;
			}
			ans = Math.max(ans, count);
			count = 0;
		}
		
		out.println(ans);
		
	}
}
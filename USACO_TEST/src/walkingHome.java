import java.util.*;

public class walkingHome {

	static Scanner in;
	static int t, n, k;
	static int[][] a;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		t = in.nextInt();
		
		while(t-->0) {
			init();
			solve();
		}
	}

}

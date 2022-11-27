import java.util.*;
import java.io.*;

public class U20DEC_ABC {

	static Scanner in;
	static int[] a;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(System.in);		
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() {	
		a = new int[7];
		
		for(int i=0; i<7; i++) a[i] = in.nextInt();
	}
	
	static void solve() throws IOException {
		
		Arrays.sort(a);
		
		System.out.println(a[0]+" "+a[1] +" " + (a[6]-a[0]-a[1]));
	}

}

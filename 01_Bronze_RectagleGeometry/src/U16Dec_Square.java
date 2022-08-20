import java.io.File;
import java.io.*;
import java.util.*;
public class U16Dec_Square {

	static Scanner in;
	static PrintWriter out;
	static int x[], y[];
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("square.in"));
		out = new PrintWriter(new File("square.out"));

		x = new int[4];
		y = new int[4];
		
		for(int i=0; i<4; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		
		Arrays.sort(x);
		Arrays.sort(y);

		int len = Math.max(x[3]-x[0], y[3]-y[0]);
		out.println(len*len);
		
		in.close();
		out.close();
	}
}

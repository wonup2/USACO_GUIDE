import java.io.*;
import java.util.*;

public class CSES1071 {

	static int n;
	static long base, ans, x, y;
	static BufferedReader in;
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		y = 0l;
		x = 0l;
		ans = 0l;
		base = 0l;

		StringBuilder sb = new StringBuilder();  //<----------
		while(n-->0) {
			st = new StringTokenizer(in.readLine()); 	
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			if(y==x) ans = x*(x-1)+1;				
			else if(x<y) {
				if(y%2==0) {
					base = y*y;
					ans = base-(x-1);
				}
				else {
					base = (y-1)*(y-1)+1;
					ans = base+(x-1);
				}
			}
			else {
				if(x%2==0) {
					base = (x-1)*(x-1)+1;
					ans = base+(y-1);
				}
				else {
					base = x*x;
					ans = base-(y-1);
				}
			}
			sb.append(ans).append("\n");
		}
				
		System.out.println(sb.toString());	
	}
}

import java.util.*;
import java.io.*;

public class CSES1713 {
	static BufferedReader in;
	static int n, x, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();		
		
		while(n-->0) {
			ans = 1;
			x = Integer.parseInt(in.readLine());
		    int num = x;
			for(int i=2; i*i <= x; i++) {
				int cnt = 1;
				while(num % i == 0) {
					cnt++;
					num /= i;
				}
				ans *= cnt;
			}
			if(num!=1) ans = ans*2;
			sb.append(ans).append("\n");
		}		
		
		System.out.print(sb.toString());
	}

}

import java.io.*;
import java.util.*;

public class CSES1081 {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, a[], max, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		a = new int[10000001];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			a[num]++;
			max = Math.max(num, max);
		}
		
		ans = 0;
		for(int d = max; d>=1; d--) {
			int cnt=0;
			for(int i = d; i <= max; i+=d) {
				cnt+= a[i];
			}
			if(cnt > 1) {
				ans = d;
				break;
			}
		}	
		
		System.out.println(ans);
	}
}

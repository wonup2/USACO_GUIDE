import java.util.*;

public class R2021_C1_JR {

	static Scanner in;
	static int s, d, r, a[][], sum;
	
	
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
		
	}
	
		
	static void init() {	
		
		s = in.nextInt();
		d = in.nextInt();
		r = in.nextInt();
		a = new int[r][];
		sum = 0;
		
	}
	
	static void solve() {
		
		for(int i=0; i<r; i++) {
			
			a[i] = new int[i+1];
			
			for(int j = 0; j <= i; j++) {

				s = conv(s);
				a[i][j] = s;
				s += d;
				
			}
		}
		
		for(int i = 0; i<r; i++) sum+=a[r-1][i];
		
		System.out.println(sum);
	}
	
	static int conv(int n) {
		
		int ans = 0;
		while(n>0) {
			
			ans += n % 10;
			n /= 10;
		}
		
		if(ans<10) return ans;
		else return conv(ans);
	}	
}

import java.util.*;

public class CSES1617 {
	static Scanner in;
	static long n, ans;
	static long mod = 1000000007;
	public static void main(String[] args) {

		in = new Scanner(System.in);
		n = in.nextLong();
		ans = 1;
		for(int i=0; i<n; i++) {
			ans*=2;
			ans%=mod;
		}
		System.out.println(ans);
	}

}

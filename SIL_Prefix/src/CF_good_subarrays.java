import java.util.*;
import java.io.*;
public class CF_good_subarrays {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int t, n, a[];
	static long ans, pre;
	static HashMap<Long, Long> map;
	static void init() throws NumberFormatException, IOException {
		n=Integer.parseInt(in.readLine());
		a = new int[n+1];
		String s = in.readLine();
		
		map = new HashMap<Long, Long>();
		map.put(0l, 0l);
		ans = 0l;
		pre = 0l;
		for(int i=1; i<=n; i++) {
			
			pre += s.charAt(i-1)-'0'-1;			
			if(map.containsKey(pre)) {
				map.put(pre, map.get(pre)+1);
				ans+=map.get(pre);
			}
			else map.put(pre, 0l);
		}
		
		//System.out.println(Arrays.toString(a));

		System.out.println(ans);
	}
	
	static void solve() {
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		
		while(t-->0) {
			init();
			solve();
		}
	}

}

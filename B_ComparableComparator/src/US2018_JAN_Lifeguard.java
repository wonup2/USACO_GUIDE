import java.util.*;
import java.io.*;

public class US2018_JAN_Lifeguard {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "lifeguards";
	static int n;
	static triple a[];
	
	static class triple implements Comparable <triple>{
		int time, lg, status;
		
		triple(int t, int i, int s){
			time = t;
			lg = i;
			status = s;
		}
		
		public String toString() {
			return time+" "+ lg+" "+status;
		}
		@Override
		public int compareTo(US2018_JAN_Lifeguard.triple o) {
			return this.time - o.time;
		}		
	}
		
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		n = Integer.parseInt(in.readLine());
		
		a = new triple[n*2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int at = Integer.parseInt(st.nextToken());
			int dt = Integer.parseInt(st.nextToken());
			
			a[i*2] = new triple(at, i, 1);
			a[i*2+1] = new triple(dt, i, 0);
		}
		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		
		int alone[] = new int[n];
		HashSet<Integer> pool = new HashSet<Integer>();
		int pre = a[0].time;
		int cur = a[0].time;
		int total = 0;
		int lg = 0;
		int status = 0;
		
		for(triple t:a) {
			
			cur = t.time;
			lg = t.lg;
			status = t.status;
					
			if(!pool.isEmpty()) total += cur - pre;
			if(pool.size()==1) alone[pool.hashCode()] += cur-pre;
			
			if(status == 1) pool.add(lg);
			else pool.remove(lg);
			
			pre = cur;
		}
		
		Arrays.sort(alone);
		int ans = total - alone[0];
		
		out.println(ans);
	}

}
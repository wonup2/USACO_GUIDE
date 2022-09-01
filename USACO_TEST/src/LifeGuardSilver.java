import java.util.*;
import java.io.*;

public class LifeGuardSilver {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int n, pre, cur, id, status, total;
	static triple a[];
	static int alone[];
	static HashSet<Integer> pool;

	static class triple implements Comparable<triple>{

		int time, id, status;
		triple(int t, int i, int s){
			time = t;
			id = i;
			status = s;
		}
		
		public String toString() {
			return time +" "+ id+" "+status;
		}
		
		@Override
		public int compareTo(triple that) {
	
			return this.time - that.time;
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
		alone = new int[n];
		pool = new HashSet<Integer>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			
			a[i*2] = new triple(Integer.parseInt(st.nextToken()), i, 1);
			a[i*2+1] = new triple(Integer.parseInt(st.nextToken()), i, 0);
		}

		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	static void solve() throws IOException {

		total = 0;
		pre = a[0].time;
		
		for(triple d:a) {
			cur = d.time;
			id = d.id;
			status = d.status;
			
			if(!pool.isEmpty()) total+=cur-pre;
			
			if(pool.size()==1) alone[pool.hashCode()] += cur-pre;
			
			if(status==1) pool.add(id);
			else pool.remove(id);
			
			pre = cur;			
		}
		
		Arrays.sort(alone);
		
		System.out.println(total-alone[0]);
	}
}
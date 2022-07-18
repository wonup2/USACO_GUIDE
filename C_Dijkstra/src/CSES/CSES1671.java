package CSES;
import java.util.*;
import java.io.*;
public class CSES1671 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, s;
	static long d[], INF=Long.MAX_VALUE;
	static boolean v[];
	static ArrayList<pair> a[];
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		solve();		
	}
	static void solve() throws IOException {
		st= new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new ArrayList[n];
		d = new long[n];
		v = new boolean[n];
		
		for(int i=0; i<n; i++) {
			a[i] = new ArrayList<pair>();
			d[i] = INF;
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			long w = Long.parseLong(st.nextToken());
			a[x].add(new pair(y, w));
		}
		
		dijkstra();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++)
			sb.append(d[i]).append(" ");
		
		System.out.println(sb.toString());
	}
	
	static void dijkstra() {
		
		PriorityQueue<pair> pq = new PriorityQueue<pair>();

		d[0] = 0;
		pq.add(new pair(0, 0));
		
		while(!pq.isEmpty()) {
			
			int curCity = pq.peek().n;
			long curCost = pq.poll().w;
			
			if(v[curCity]) continue;
			v[curCity] = true;
			
			for(pair p:a[curCity]) {
				
				if(v[p.n]) continue;
				
				int nextCity = p.n;
				long nextCost = p.w;
				long newCost = curCost + nextCost;
				
				if(newCost < d[nextCity]) {
					d[nextCity] = newCost ; 
					pq.add(new pair(nextCity, newCost));
				}
			}
		}		
	}
	
	static class pair implements Comparable<pair>{

		int n;
		long w;
		pair(int n, long w){
			this.n = n;	this.w = w;
		}
		
		@Override
		public int compareTo(pair o) {
			if(this.w < o.w) return -1;
			else return 1;
		}
		public String toString() {
			return n+" "+w;
		}
	}
}

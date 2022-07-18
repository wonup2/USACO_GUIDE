import java.util.*;

public class Dijkstra_Template2 {
	
	static Scanner in;
	static int n, m, s, d[], INF=100000000;
	static boolean v[];
	static ArrayList<pair> a[];
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		solve();		
	}
	static void solve() {
		n = in.nextInt();
		m = in.nextInt();
		s = in.nextInt()-1;
		a = new ArrayList[n];
		d = new int[n];
		v = new boolean[n];
		
		for(int i=0; i<n; i++) {
			a[i] = new ArrayList<pair>();
			d[i] = INF;
		}
		for(int i=0; i<m; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			int w = in.nextInt();
			a[x].add(new pair(y, w));
			a[y].add(new pair(x, w));
		}
		
		dijkstra();
		System.out.println(Arrays.toString(d));
	}
	
	static void dijkstra() {
		
		PriorityQueue<pair> pq = new PriorityQueue<pair>();

		d[s] = 0;
		pq.add(new pair(s, 0));
		
		while(!pq.isEmpty()) {
			
			int cur_n = pq.peek().n;
			int cur_w = pq.poll().w;
			if(v[cur_n]) continue;
			
			v[cur_n] = true;
			
			for(pair next:a[cur_n]) {
				if(v[next.n]) continue;
				
				if(cur_w + next.w < d[next.n]) {
					d[next.n] = cur_w + next.w;
					pq.add(new pair(next.n, cur_w + next.w));
				}
			}
		}		
	}
	static class pair implements Comparable<pair>{

		int n, w;
		pair(int n, int w){
			this.n = n;	this.w = w;
		}
		
		@Override
		public int compareTo(Dijkstra_Template2.pair o) {
			return this.w - o.w;
		}
		public String toString() {
			return n+" "+w;
		}
	}
}

/*
4 5 1
1 2 3
1 3 6
1 4 7
2 3 1
3 4 1
[0, 3, 4, 5]


6 10 1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 4 3
3 5 1
3 6 5
4 5 1
5 6 2
[0, 2, 3, 1, 2, 4]
*/


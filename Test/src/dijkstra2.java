import java.util.*;

public class dijkstra2 {

	static ArrayList<Pair> []a;
	static int INF = 100000000;
	static int n, m, s, d[];

		

	public static void main(String[] args) {

		init();
		dijkstra();
		System.out.println(Arrays.toString(d));

	}



	static void dijkstra(){

		d[s] = 0;
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		q.add(new Pair(s,0));		

		while(!q.isEmpty()){
			int cur = q.peek().v;
			int w = q.poll().w;
			if(d[cur] < w) continue; 			

			for(Pair next :  a[cur]){	
				
				if(w + next.w < d[next.v]){
					d[next.v] = w + next.w ;
					q.add(new Pair(next.v, d[next.v]));
				}
			}			
		}
	}	

	@SuppressWarnings("unchecked")
	static void init(){

		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		s = in.nextInt()-1;

		a = new ArrayList[n];
		d = new int[n];

		for(int i=0; i<n; i++){
			a[i] = new ArrayList<Pair>();
			d[i] = INF;
		}

		for(int i=0; i<m; i++){
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			int w = in.nextInt();
			a[x].add(new Pair(y, w));
			a[y].add(new Pair(x, w));
		}
		in.close();
	}
	
	static class Pair implements Comparable<Pair>{

		int v, w;

		Pair(int n, int p){
			v = n;
			w = p;
		}

		public String toString(){
			return v + " " + w;
		}

		@Override
		public int compareTo(Pair o) {
			return this.w - o.w;
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


*/
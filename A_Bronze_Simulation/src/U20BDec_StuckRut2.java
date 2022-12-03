import java.util.*;

public class U20BDec_StuckRut2 {
	static Scanner in;
	static int n, dist[], dx, dy;
	static LinkedList<cows> E, N;
	static boolean stuck[];
	
	static class cows{
		int id, x, y;
		cows(int a, int b, int c){
			id = a;
			x = b; 
			y = c;
		}
		public String toString() {
			return id+" "+ x +" "+y;
		}
	}
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}

	static void init() {
		
		n = in.nextInt();
		E = new LinkedList<cows>();
		N = new LinkedList<cows>();
		
		for(int i=0; i<n; i++) {
			char c = in.next().charAt(0);
			int x = in.nextInt();
			int y = in.nextInt();
			if(c=='E') E.add(new cows(i, x, y));
			else N.add(new cows(i, x, y));
		}
		
		Collections.sort(E, new Comparator<cows>(){
            public int compare(cows a,cows b){
            	return a.y-b.y;
            }});
		
		Collections.sort(N, new Comparator<cows>() {
			public int compare(cows a,cows b){
				return a.x-b.x;
			}});
		
		stuck = new boolean[n];
		dist = new int[n];
	}
	
	static void solve() {
		
		for(cows e:E) {
			for(cows n:N) {
				if(e.x>n.x || e.y<n.y || stuck[n.id] || stuck[e.id]) continue;
				dx = n.x-e.x;
				dy = e.y-n.y;
				
				if(dx>dy) {
					stuck[e.id]=true;
					dist[e.id]=dx;
				}
				else if(dx<dy) {
					stuck[n.id]=true;
					dist[n.id]=dy;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int n:dist) {
			if(n==0) sb.append("Infinity");
			else sb.append(n);
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	
	}

	
}

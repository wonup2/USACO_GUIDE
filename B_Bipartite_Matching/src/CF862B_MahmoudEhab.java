import java.util.*;
import java.io.*;

public class CF862B_MahmoudEhab {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, s[];
	static ArrayList<Integer>[] a;
	static boolean v[];
	

	static void init() throws NumberFormatException, IOException {
		
		n = Integer.parseInt(in.readLine());
		a = new ArrayList[n+1];
		for(int i=1; i<=n; i++) 
			a[i] = new ArrayList<Integer>();
		
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x].add(y);
			a[y].add(x);
		}
		
		s = new int[n+1];
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		
		for(int i=1; i<=n; i++) {
			if(s[i]==0) {
				s[i] = 1;
				bfs(i);
			}
		}
		
		//System.out.println(Arrays.toString(s));
		long x=0l, y=0l;
		for(int i=1; i<=n; i++) {
			if(s[i]==1) x++;
			else y++;
		}
		
		System.out.println(x*y-(n-1));
	}
	
	static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		v = new boolean[n+1];
		q.add(i);
		v[i] = true;

		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int next:a[curr]) {
				if(v[next]) continue;
				v[next]=true;
				
				if(s[next]==0) {
					s[next]=s[curr]*-1;
					q.add(next);
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
	}

}

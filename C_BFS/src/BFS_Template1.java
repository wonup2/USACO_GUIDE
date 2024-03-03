import java.util.*;

public class BFS_Template1 {
	
	static Scanner in;
	static boolean[] v;
	static ArrayList<Integer>[] a;
	static int n, m, ans;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);		
		init();
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();		
		
		v = new boolean[n];
		a = new ArrayList[n];
		for(int i=0; i<n; i++)
			a[i] = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++){
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			a[x].add(y);
			a[y].add(x);
		}		
		
		v = new boolean[n];
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		for(int i=0; i<n; i++) {
			if(!v[i]) {
				dfs(i);
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	
	static void dfs(int i) {
		
		v[i] = true;
		
		for(int node: a[i]) {
			
			if(v[node]) continue;
			dfs(node);
		}
	}
	
	
	static void bfs(int s){
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		
		while(!q.isEmpty()){
			
			int x=q.remove();
			if(v[x]) continue;
			
			v[x]=true;
			System.out.print(x+1+ " ");
			
			for(int y:a[x]) if(!v[y]) q.add(y);
		}
	}
}


/*
6 4 
1 2
1 3
4 5
5 6


2
*/
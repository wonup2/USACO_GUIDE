import java.util.*;

public class BFS_Template1 {
	
	static Scanner in;
	static boolean[] v;
	static ArrayList<Integer>[] a;
	static int n, m, s;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);		
		init();
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		int s = in.nextInt()-1;
		
		v = new boolean[n];
		a = new ArrayList[n];
		for(int i=0; i<n; i++)
			a[i] = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++){
			int u = in.nextInt()-1;
			int v = in.nextInt()-1;
			a[u].add(v);
			a[v].add(u);
		}
			
		bfs(s);
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
4 5 1
1 2
1 3
1 4
2 4
3 4


1 2 4 3  DFS
1 2 3 4  BFS
*/
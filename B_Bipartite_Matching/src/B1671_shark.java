import java.io.*;
import java.util.*;

public class B1671_shark {

	static List<Integer>[] a;
	static boolean[] v;
	static int n, b[];
	static BufferedReader in;
	static StringTokenizer st;
	static class shark{
		int x, y, z;
		shark(int a, int b, int c){
			x=a; y=b; z=c;
		}
	}
	static shark shark[];
	
	public static void main(String[] args) throws  IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		System.out.println(Arrays.toString(b));
	}
	
	static void init() throws IOException {
		
		n = Integer.parseInt(in.readLine());
		a = new ArrayList[n+1];
		shark = new shark[n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			shark[i] = new shark(x, y, z);
		}
				
		for(int i=1; i<=n; i++) 
			a[i] = new ArrayList<Integer>();
				
		for(int i=1; i<n; i++) {
			for(int j=i+1; j<=n; j++) {
				if(shark[i].x>=shark[j].x && shark[i].y>=shark[j].y && shark[i].z>=shark[j].z)
					a[i].add(j);
				else if(shark[i].x <=shark[j].x && shark[i].y<=shark[j].y && shark[i].z<=shark[j].z)
					a[j].add(i);
			}			
		}
		
		v = new boolean[n+1];
		b = new int[n+1];
	}
	
	static void solve() {
		
		int cnt = 0;
		
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<2; j++) {
				Arrays.fill(v, false);
				if(dfs(i)) cnt++; 
			}
		}
		System.out.println(n-cnt);
	}
	
	static boolean dfs(int cow) {
		
		for(int i : a[cow]) {
			
			if(v[i]) continue;
			v[i]=true;
			if(b[i]==0 || dfs(b[i])) {
				b[i] = cow;
				return true;
			}
		}
		
		return false;
	}
}
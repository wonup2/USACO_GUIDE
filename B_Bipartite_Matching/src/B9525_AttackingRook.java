import java.io.*;
import java.util.*;

public class B9525_AttackingRook {
	
	static List<Integer>[] a;
	static boolean[] v;
	static int n, left[], right[];
	static Scanner in;
	static StringTokenizer st;
	
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		
		n = in.nextInt();
		char map[][] = new char[105][105];
		for(int i=1; i<=n; i++) {
			char temp[]= in.next().toCharArray();
			for(int j=1; j<=n; j++) {
				map[i][j] = temp[j-1];
			}
			
		}
		
		int row[][] = new int[105][105];
		int col[][] = new int[105][105];
		int cnt = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j]=='.') {
					row[i][j]=cnt;
					if(j==n || map[i][j+1]=='X') cnt++;
				}
			}
		}
		
		int r_cnt=cnt;
		cnt=1;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(map[j][i]=='.') {
					col[j][i]=cnt;
					if(j==n || map[j+1][i]=='X') cnt++;
				}
			}
		}
		
		a = new ArrayList[r_cnt+1];
        Arrays.setAll(a, i -> new ArrayList<Integer>());
		
        for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j]=='.') 
					a[row[i][j]].add(col[i][j]);
			}
		}
        
        v = new boolean[5005];
        left = new int[r_cnt+1];
        right = new int[cnt];
        int match=0;
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        
        for(int i=1; i<=r_cnt; i++) {
        	Arrays.fill(v, false);
        	if(dfs(i)) match++;
        }

        print(row);
        print(col);
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        System.out.println(match);
        
	}

	static void solve() {
		
	}
	
	static boolean dfs(int i) {
		v[i] = true;
		for(int next:a[i]) {
			if(right[next]==-1 || !v[right[next]] && dfs(right[next])) {
				left[i] = next;
				right[next]=i;
				return true;
			}
		}
		
		return false;
	}
	
	static void print(int a[][]) {
		System.out.println();

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}

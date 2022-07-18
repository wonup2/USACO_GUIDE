package CODEQUEST;
import java.util.*;
public class prob16 {
	static int dr[] = {-1, 1, 0, 0, 1, 1, -1, -1};
	static int dc[] = {0, 0, -1, 1, 1, -1, -1, 1};
	static char a[][];
	static int n, m, index, num;
	static String s;
	static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0; i<n; i++) {
			init();
			solve();
		}
		
		in.close();
		

	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		//System.out.println(n + " " + m);
		a = new char[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				a[i][j] = in.next().charAt(0);
			}
		}
		
//		for(int j = 0; j < n; j++) {
//            for(int i = 0; i < m; i++) {
//                System.out.print(a[j][i] + " ");
//            }
//            System.out.println();
//		} 
		num = in.nextInt();
		in.nextLine();
	}
	
	static void solve() {
		
		for(int k=0; k<num; k++) {
			s = in.nextLine();
//			System.out.println(s);
			index = 0;
			boolean flag = false;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(a[i][j] == s.charAt(0)) {
						if(dfs(i, j, index)) {
							System.out.println(s);
							flag = true;
							break;
						}
					}
				}
				if(flag) break;
			}
		}
		
		
		
	}
	
	static boolean dfs(int r, int c, int index) {
		
		if(s.charAt(index) == a[r][c]) {
			if(index == s.length()-1) return true;
			
			for(int i=0; i<8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
				
				if(dfs(nr, nc, index+1)) return true; 
				
			}
			return false;
		}
		return false;
		
	}

}

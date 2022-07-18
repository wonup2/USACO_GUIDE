import java.util.*;

public class FloydWashall_Template {
	static Scanner in;
	static int n, m, d[][];
	static int INF = 100000;
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		floydWarshall();		
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		
		d = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++) {
				if(i==j) continue;
				d[i][j] = INF;
			}
		
		for(int i=0; i<m; i++) {
			d[in.nextInt()-1][in.nextInt()-1] = in.nextInt();
		}
		
		System.out.println(Arrays.deepToString(d));

	}
	
	static void floydWarshall() {
		
		for(int p = 0; p<n; p++) 
			for(int s = 0; s<n; s++) 
				for(int e = 0; e<n; e++)
					d[s][e] = Math.min(d[s][p] + d[p][e] ,  d[s][e]);
		
			
		System.out.println(Arrays.deepToString(d));
	}

}

/*

4 7
1 2 5
2 1 7
2 3 9
3 1 2
3 4 4
1 4 8
4 3 3

*/

import java.io.*;
import java.util.*;

public class B9576_book1 {
	static List<int[]> a;
	static boolean[] v;
	static int t, n, m, b[];
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		sb = new StringBuilder();

		while(t-->0) {
			init();
			solve();
		}
		System.out.println(sb.toString());

	}
	static void init() throws IOException {		

		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
			
		v = new boolean[n+1];
		a = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());	
			a.add(new int[] {x,y});
		}			
	}
	
	static void solve() {
		
		Collections.sort(a, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
			
		System.out.println(Arrays.toString(a.get(0)));
		System.out.println(Arrays.toString(a.get(1)));
		System.out.println(Arrays.toString(a.get(2)));


		int total=0;
		for(int[] num : a) {
			int start =num[0];
			int end = num[1];
			for(int i=start; i<=end; i++) {
				if(!v[i]) {
					v[i] = true;
					total++;
					break; //<--- 한권 가졌으니까 꺼져
				}
			}
		}
		
		sb.append(total+"\n");		
	}
}
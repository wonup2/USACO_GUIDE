import java.util.*;
import java.io.*;

public class CSES1641SumofThreeValues {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, x;
	static long sum;
	static pair a[];
	
	static class pair implements Comparable<pair>{
		int num, idx;
		pair(int n, int i){
			num = n; idx=i;
		}
		
		public int compareTo(pair that) {
			return this.num - that.num;
		}
		
		public String toString() {
			return num+" "+idx;		
		}
	}
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
	
	}

	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		if(n<3) {
			System.out.println("IMPOSSIBLE");
			return;
		}
		a = new pair[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a[i] = new pair(Integer.parseInt(st.nextToken()), i+1);
		
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
		solve();
	}
	
	static void solve() {

		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		int i=0;
		for(i=0; i<3; i++) {
			list.add(a[i].idx);
			sum+=(long)a[i].num;
		}
		
		while(sum!=x && i<n-3) {
			sum+=(long)a[i].num - (long)a[i-3].num;		System.out.println(sum);

			list.remove(0);
			list.add(a[i].idx);
			if(sum==x) break;
			i++;
		}
		if(sum!=x) {
			System.out.println("IMPOSSIBLE"); return;
		}
		
		Collections.sort(list);
		for(int num:list) 
			System.out.print(num+" ");
		
			
	}
}

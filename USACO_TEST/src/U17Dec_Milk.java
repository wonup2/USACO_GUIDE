import java.util.*;
import java.io.*;

public class U17Dec_Milk{

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "measurement";
	static int n, milk[];
	static boolean pre[], cur[];
	static triple a[];

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		
		a = new triple[n];
		
		for(int i=0; i<n; i++) {
			st= new StringTokenizer(in.readLine());
			int day = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int namei = 0;
			if(name.equals("Elsie")) namei=1;
			else if(name.equals("Mildred")) namei=2;
			int milk = Integer.parseInt(st.nextToken());
			
			a[i] = new triple(day, namei, milk);
		}
		
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
		
		milk = new int[]{7, 7, 7};
		cur = new boolean[3];
		pre = new boolean[]{true, true, true};
		
	}
	
	static void solve() {
		
		int change=0;
		
		for(int i=0; i<n; i++) {
			
			milk[a[i].name]+=a[i].milk;
			
			int max = Math.max(milk[0], Math.max(milk[1], milk[2]));
			
			for(int j=0; j<3; j++) {
				if(milk[j]==max) cur[j]=true;
				else cur[j] = false;
			}
			
		
			if(!Arrays.equals(pre, cur)) change++;
			
			
			for(int j=0; j<3; j++)
				pre[j] = cur[j];
			
			
		}
		
		out.println(change);
	}
	
	static class triple implements Comparable<triple>{

		int day, name, milk;
		triple(int a, int b, int c){
			day = a;
			name = b;
			milk = c;
		}
		
		public String toString() {
			return day+" "+name+" "+milk;
		}
		
		@Override
		public int compareTo(triple that) {
			return this.day - that.day;			
		}		
	}
}
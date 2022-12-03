import java.util.*;
import java.io.*;

public class U19Feb_SleepyCowHerding {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int a[];

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());

		a = new int[3];
		for(int i=0; i<3; i++)
			a[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(a);
	}
	
	static void solve() {
		//min
		if(a[0]+2==a[2]) out.println(0);
		else if(a[2]-a[1]==2 || a[1]-a[0]==2) out.println(1);
		else out.println(2);
		
		//max
		out.println(Math.max(a[2]-a[1], a[1]-a[0])-1);
	}

}
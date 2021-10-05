import java.util.*;
import java.io.*;

public class paint1 {
	static BufferedReader in;
	static PrintWriter out;
	static boolean[] a;
	static int ans, x, y;
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("paint.in"));
		out = new PrintWriter(new File("paint.out"));
		
		a = new boolean[101];
		ans = 0;
		solve(); 
		solve();
		out.println(ans);
		
		out.close();
		in.close();
	}

	static void solve() throws IOException{
		StringTokenizer st = new StringTokenizer(in.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		for(int i=x; i<y; i++) {
			if(!a[i]) ans++;
			a[i]=true;
		}
	}
}

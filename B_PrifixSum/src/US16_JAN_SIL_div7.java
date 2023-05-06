import java.util.*;
import java.io.*;

public class US16_JAN_SIL_div7 {

	static BufferedReader in;
	static PrintWriter out;
	static int n, x, ans;
	static HashMap<Integer, Integer> m;
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("div7.in"));
		out = new PrintWriter(new File("div7.out"));
		solve();		
		in.close();
		out.close();
	}

	static void solve() throws IOException {
		n = Integer.parseInt(in.readLine());
		m = new HashMap<Integer, Integer>();
		m.put(0, 0);
		int x = 0;
		
		for(int i=1; i<=n; i++) {
			x = (x+Integer.parseInt(in.readLine()))%7;
			if(m.containsKey(x)) ans = Math.max(ans, i-m.get(x));
			else m.put(x, i);
		}
		
		out.println(ans);
	}
}

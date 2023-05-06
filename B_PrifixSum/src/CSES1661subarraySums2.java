import java.util.*;
import java.io.*;

public class CSES1661subarraySums2 {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, x;
	static long a, seek, ans;
	static HashMap<Long, Integer> m;
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		m = new HashMap<Long, Integer>();
		m.put(0l, 1);
		
		st = new StringTokenizer(in.readLine());

		while(n-->0) {
			a += Long.parseLong(st.nextToken());
			seek = a-x;
			
			if(m.containsKey(seek)) ans+=m.get(seek);
			
			if(m.containsKey(a))m.put(a, m.get(a)+1);
			else m.put(a, 1);

		}

		System.out.println(ans);
	}
}

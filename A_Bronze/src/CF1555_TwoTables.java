import java.io.*;
import java.util.StringTokenizer;
public class CF1555_TwoTables {

	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder out;
	static int t, W, H, x1, y1, x2, y2, w1, h1, w2, h2, min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		out = new StringBuilder();
		
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			init();
			out.append(solve()).append("\n");
		}
		
		System.out.print(out.toString());
	}

	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		
		w1 = x2-x1;
		h1 = y2-y1;
		
		st = new StringTokenizer(in.readLine());
		w2 = Integer.parseInt(st.nextToken());
		h2 = Integer.parseInt(st.nextToken());
		
		min = Integer.MAX_VALUE;
	}
	
	static int solve() {
		
		if(w1+w2>W && h1+h2>H) return -1;
		
		if(w1+w2<=W) min = Math.min(w2-x1, w2-(W-x2));	
		
		if(h1+h2<=H) min = Math.min(min, Math.min(h2-y1, h2-(H-y2)));	
		
		if(min<=0) return 0;
		else return min;		
	}
}

import java.util.*;
import java.io.*;

public class U18Dec_BackForth {

	static Scanner in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static int a[], b[], _a[], _b[];
	static HashSet<Integer> set;

	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
	
		a = new int[10];
		_a = new int[10];
		b = new int[10];
		_b = new int[10];
		
		for(int i=0; i<10; i++) a[i] = in.nextInt();
		for(int i=0; i<10; i++) b[i] = in.nextInt();
		
		_a = a.clone();
		_b = b.clone();
		
		set = new HashSet<Integer>();
	}
	
	static void solve() {
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				int tw = -a[i] + b[j];
				int temp = a[i];
				a[i] = b[j];
				b[j] = temp;
				
				for(int k=0; k<10; k++) {
					for(int l=0; l<10; l++) {
						int tf = tw - a[k] + b[l];
						set.add(tf);
					}
				}
				
				a = _a.clone();
				b = _b.clone();
			}
		}
		
		out.println(set.size());
	}

}
import java.util.*;
import java.io.*;

public class U18B_tttt {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static char a[][];
	static HashSet<String> one, two;
	static TreeSet<Character>[] t;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		a = new char[3][];
		
		for(int i=0; i<3; i++)
			a[i] = in.readLine().toCharArray();		
		
		t = new TreeSet[8];
		for(int i=0; i<8; i++)
			t[i] = new TreeSet<Character>();
		
		one = new HashSet<String>();
		two = new HashSet<String>();
	}
	
	static void solve() {
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				t[i].add(a[j][i]);
				t[i+3].add(a[i][j]);
			}
			t[6].add(a[i][i]);
			t[7].add(a[i][2-i]);
		}
		
		for(int i=0; i<8; i++) {
			if(t[i].size()==1) one.add(t[i].first()+"");
			else if(t[i].size()==2) two.add(t[i].first()+""+t[i].last());
		}		
		
		out.println(one.size()+"\n"+ two.size());
	}

}
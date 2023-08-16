import java.util.*;
import java.io.*;

public class TicTacToe1 {
	
	static Scanner in;
	static PrintWriter out;
	static String file = "tttt";
	static char[][] a;
	static HashSet<TreeSet<Character>> one, two;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new Scanner(new File(file+".in"));
		out = new PrintWriter(new File(file+".out"));
				
		init();
		solve();
	
		in.close();
		out.close();
	}
	
	static void init() {
		
		a = new char[3][];
		
		for(int i=0; i<3; i++) {
			a[i] = in.next().toCharArray();
		}
		
		one = new HashSet<TreeSet<Character>>();
		two = new HashSet<TreeSet<Character>>();
	}

	static void solve() {
		
		TreeSet<Character> s = new TreeSet<Character>();
		
		for(int i =0; i<3; i++) {
			s = new TreeSet<Character>();
			for(int j = 0; j<3;j++) s.add(a[i][j]); 
			
			if(s.size()==1) one.add(s);
			else if(s.size()==2) two.add(s); 
		}
		
		for(int i = 0; i<3; i++) {
			s = new TreeSet<Character>();
			for(int j = 0; j<3;j++) s.add(a[j][i]);
			
			if(s.size()==1) one.add(s);
			else if(s.size()==2) two.add(s); 
		}
				
		s = new TreeSet<Character>();
		for(int i=0; i<3;i++) s.add(a[i][i]);			
		if(s.size()==1) one.add(s);
		else if(s.size()==2) two.add(s); 
		
		s = new TreeSet<Character>();
		for(int i=0; i<3; i++) s.add(a[i][2-i]);
		if(s.size()==1) one.add(s);
		else if(s.size()==2) two.add(s); 

		out.println(one.size() + "\n" + two.size());
	}
}
import java.io.*;
import java.util.*;
public class U18US_TicTacToe {
	static Scanner in;
	static PrintWriter out;
	static char a[][];
	static int one, two;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new FileReader("tttt.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
        init();
        solve();        
        out.close();
        in.close();       
	}
	static void init() throws NumberFormatException, IOException {
		a = new char[3][];
				
		for(int i=0; i<3; i++)	
			a[i] = in.next().toCharArray();	
		
	}
	
	static void solve() {
		TreeSet<Character>[] team = new TreeSet[8];
		
		for(int i=0; i<8; i++)
			team[i] = new TreeSet<Character>();
	
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				team[i].add(a[j][i]);
				team[3+i].add(a[i][j]);
			}
			team[6].add(a[i][i]);
			team[7].add(a[i][2-i]);
		}
		

		HashSet<Character> one = new HashSet<Character>();
		HashSet<String> two = new HashSet<String>();

		for(int i=0; i<8; i++) {
			if(team[i].size()==1) one.add(team[i].first());
			else if(team[i].size()==2) two.add(team[i].first()+""+team[i].last());
		}
		
		out.println(one.size()+"\n"+two.size());
	}
	
}
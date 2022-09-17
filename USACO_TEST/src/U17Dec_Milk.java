import java.util.*;
import java.io.*;

public class U17Dec_Milk {

	static Scanner in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "test";
	static triple a[];
	static int n, g, boardCow, boardMilk, cow, milk, maxMilk, maxCow, ans;
	static TreeMap<Integer, Integer> m;
	static HashMap<Integer, Integer> c;
	
	static class triple implements Comparable<triple>{
		
		int day, id, milk;
		triple(int d, int i, int m){
			day = d;
			id = i;
			milk = m;
		}
		
		public String toString() {
			return day+" "+id+" "+milk;
		}
		
		@Override
		public int compareTo(U17Dec_Milk.triple o) {
			return this.day-o.day;
		}
	}

	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		n = in.nextInt();
		g = in.nextInt();
		a = new triple[n];
		for(int i=0; i<n; i++)
			a[i] = new triple(in.nextInt(), in.nextInt(), in.nextInt());
		
		Arrays.sort(a);
		
		boardCow = 1000000000;
		boardMilk = g;
		
		m = new TreeMap<Integer, Integer>();
		c = new HashMap<Integer, Integer>();
		
		m.put(g, 1000000000);
		boardCow=1000000000;
		boardMilk=g;
	}
	
	static void solve() {
		
		for(triple t:a) {
			
			cow = t.id;
			
			if(c.containsKey(cow))milk = c.get(cow);
			else milk = g;
			
			m.put(milk, m.get(milk)-1);
			if(m.get(milk)==0) m.remove(milk);
			
			
			//----------------
			if(boardMilk==milk) boardMilk += t.milk;
			
			milk += t.milk;
			
			c.put(cow, milk);
			if(m.containsKey(milk)) m.put(milk, m.get(milk)+1);
			else m.put(milk, 1);
			
			maxMilk = m.lastKey();
			maxCow = m.get(maxMilk);
			
			
			//----------------
			if(boardMilk != maxMilk || boardCow != maxCow) {
				ans++;
				boardMilk = maxMilk;
				boardCow = maxCow;
			}					
		}
		
		out.println(ans);
	}

}
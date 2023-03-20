import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class gift1 {

	static Scanner in;
	static PrintWriter out;
	static int NP, money, cnt, gift, remain;
	static String giver, person;
	static LinkedHashMap<String, Integer> map;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new FileReader("test.in"));
		out = new PrintWriter(new FileWriter("test.out"));
		
		init();
		
		in.close();
		out.close();

	}

	static void init() {
		
		NP = in.nextInt(); System.out.println(NP);
		map = new LinkedHashMap<String, Integer>();
		
		for(int i=0; i<NP; i++) {
			map.put(in.next(), 0);
		}
		
		while(NP-->0) solve();
		
		System.out.println(map);
	}
	
	static void solve() {
		
		giver = in.next();
		money = in.nextInt();
		cnt = in.nextInt();
		
		gift = money/cnt;
		remain = money%cnt;
		
		map.put(giver, map.get(giver)-money+remain);
		
		//put, get
		for(int i=0; i<cnt; i++) {
			person = in.next();
			map.put(person, map.get(person)+gift);
		}
	}
}

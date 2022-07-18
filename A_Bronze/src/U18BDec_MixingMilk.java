import java.util.*;
import java.io.*;


public class U18BDec_MixingMilk {

	static Scanner in;
	static PrintWriter out;
	static int c1, c2, c3, m1, m2, m3;
	static boolean shell[];
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		//in = new Scanner(new File("mixmilk.in"));
		//out = new PrintWriter(new File("mixmilk.out"));
				
		init();
		solve();
				
		//in.close();
		//out.close();
	}
	
	static void init() {
		c1 = in.nextInt(); m1 = in.nextInt();
		c2 = in.nextInt(); m2 = in.nextInt();
		c3 = in.nextInt(); m3 = in.nextInt();	
	}
	
	static void solve() {
		
		for(int i=0; i<33; i++) {
			//1->2
			int space = c2-m2;
			if(m1<=space) {
				m2 += m1;
				m1 = 0;
			}
			else {
				m2 = c2;
				m1 -= space;
			}

			//2->3
			space = c3-m3;
			if(m2<=space) {
				m3 += m2;
				m2 = 0;
			}
			else {
				m3 = c3;
				m2 -= space;
			}

			//3->1
			space = c1-m1;
			if(m3<=space) {
				m1 += m3;
				m3 = 0;
			}
			else {
				m1 = c1;
				m3 -= space;
			}
		}
		
		//1->2
		int space = c2-m2;
		if(m1<=space) {
			m2 += m1;
			m1 = 0;
		}
		else {
			m2 = c2;
			m1 -= space;
		}
		
		System.out.println(m1+"\n"+m2+"\n"+m3);
		
	}

}

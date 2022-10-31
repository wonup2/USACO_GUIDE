import java.io.*;
import java.util.Scanner;
public class UMixingMilk {
	
	static String file = "test";
	static Scanner in;
	static PrintWriter out;
	static int m1, m2, m3, c1, c2, c3;

	public static void main(String[] args) throws FileNotFoundException {
		
		in = new Scanner(new File(file + ".in"));
		out = new PrintWriter(new File(file + ".out"));
		
		init();
		solve();
		
		in.close();
		out.close();


	}
	
	static void init() {
		
		c1 = in.nextInt();
		m1 = in.nextInt();
		c2 = in.nextInt();
		m2 = in.nextInt();
		c3 = in.nextInt();
		m3 = in.nextInt();
		
	}
	
	static void solve() {
//		System.out.println(c1+" "+c2+" "+c3);
//		System.out.println(m1+" "+ m2+" "+m3);

		
		for(int i = 0; i<33; i++) {
			if(m1 + m2 >=c2) {
				
				m1 = m1 + m2 - c2;
				m2 = c2;
			}else {
				m2+=m1;
				m1 = 0;
			}
			
			//System.out.println(m1+" "+ m2+" "+m3);
			
			if(m2 + m3 >=c3) {
				
				m2 = m2 + m3 - c3;
				m3 = c3;
			}else {
				m3+=m2;
				m2 = 0;
			}
			
			//System.out.println(m1+" "+ m2+" "+m3);

			if(m3 + m1 >=c1) {
				m3 = m1 + m3 - c1;
				m1 = c1;

			}else {
				m1+=m3;
				m3 = 0;
			}
			//System.out.println(m1+" "+ m2+" "+m3);

		}
		
		if(m1 + m2 >=c2) {
			m1 = m1 + m2 - c2;
			m2 = c2;

		}else {
			m2+=m1;
			m1 = 0;
		}
		
		out.println(m1);
		out.println(m2);
		out.println(m3);
		
		
	}

}
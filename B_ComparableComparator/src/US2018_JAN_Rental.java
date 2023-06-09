
import java.io.*;
import java.util.*;

public class US2018_JAN_Rental {
	
	static BufferedReader in;
	static PrintWriter out;
	static int n, m, r;
	static int [] profit;
	static int [] rental;
	static int [] gallons;
	static price store [];

	public static void main(String[] args) {
		
		try {
			init();
	        solve();
	        out.close();
	        in.close();
	    }
	    catch(Exception e) {
	        System.out.println("Error");
	        e.printStackTrace();
	    }

	}
	
	public static void init () throws IOException {
		
		in = new BufferedReader(new FileReader ("test.in"));
		out = new PrintWriter (new File ("test.out"));
		StringTokenizer st = new StringTokenizer (in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		rental = new int [r];
		profit = new int [n];
		gallons = new int [n];
		int [] temp = new int [n];
		for (int i = 0; i < n; i++) temp[i] = Integer.parseInt(in.readLine());
		Arrays.sort(temp);	

		store = new price[m];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer (in.readLine());
			int g = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			store[i] = new price (g, c);
		}
		
		for (int i = 0; i < r; i++)	rental[i] = Integer.parseInt(in.readLine());
		for (int i = n-1; i >= 0; i--) gallons [i] = temp[n-i-1];

		Arrays.sort(rental);
		Arrays.sort(store);	
		
		System.out.println(Arrays.toString(gallons));
		System.out.println(Arrays.toString(store));
		System.out.println(Arrays.toString(rental));
	}
	
	static void solve () {
		
		int cur = 0;
		for (int i = 0; i < n; i++) {
			while (cur < m && gallons[i] > 0) {
				int usedGal = Math.min(gallons[i], store[cur].gallon);
				int price = store[cur].cents;
				profit[i] += usedGal*price;
				gallons[i] -= usedGal;
				store[cur].gallon -= usedGal;
				if (store[cur].gallon == 0) {
					cur++;
				}
			}
		}
		System.out.println(Arrays.toString(profit));
		for (int i = n-1, j = r-1; i >= 0 && j >= 0; i--, j--) 
			profit [i] = Math.max(profit[i], rental[j]);
		
		
		long sum = 0;
		for (int i = 0; i < n; i++) 
			sum += profit[i];
		
		out.println(sum);
	}
	
	static class price implements Comparable <price>{
		
		public int gallon;
		public int cents;
		
		public price (int g, int c) {
			gallon = g;
			cents = c;
		}
		public int compareTo(price that) {
			return that.cents - this.cents;
		}
		public String toString() {
			return gallon + " " + cents;
		}
		
	}

}



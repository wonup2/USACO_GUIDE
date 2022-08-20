
import java.io.*;
import java.util.*;

public class USACO2017DecBronze_MilkMeasurement {

    static Scanner in;
	static PrintWriter out;
	static int output[] = {7, 7, 7}, n, ans = 0;
	static boolean leaderboard[] = {true, true, true};
	static TreeMap<Integer, Integer> day_cow = new TreeMap<Integer, Integer>();
	static TreeMap<Integer, Integer> cow_change = new TreeMap<Integer, Integer>();
    
    public static void main(String[] args) throws IOException {

        in = new Scanner(System.in);        
		//in = new Scanner(new File("traffic.in"));
		//out = new PrintWriter(new File("traffic.out"));
		
        init();
        solve();
        
        in.close();
        //out.close();
    }
    
    static void init() {    

    	n = in.nextInt();
    	
    	for(int i = 0; i < n; i++) {
    		int day = in.nextInt();
    		String name = in.next();
    		int cow;
    		if(name.equals("Bessie")) cow = 0;
    		else if(name.equals("Elsie")) cow = 1;
    		else cow = 2;
    		int change = in.nextInt();
    		day_cow.put(day, cow);
    		cow_change.put(cow, change);
    	}
    	
    	System.out.println(day_cow);
    	System.out.println(cow_change);
    	
    	System.out.println();
    }
    
    static void solve() {
    	  
    	for(int i = 0; i < n; i++) {
    		int cow = (int)day_cow.values().toArray()[i];  System.out.println(cow);
    		int change = cow_change.get(cow);   System.out.println(change);
    		output[cow] += change;
			
    		
    		System.out.println(Arrays.toString(output));
    		System.out.println();
    		ArrayList<Integer> index = new ArrayList<Integer>();
    		int max = 0;
    		
    		
    		for(int j = 0; j < 3; j++) {
    			if(output[j] > max) {
    				max = output[j];
    				index.clear();
    				index.add(j);
    			}
    			if(output[j] == max) index.add(j);
    		}
    		System.out.println("index " + index);
    		
    		boolean[] temp = leaderboard.clone();
			leaderboard = new boolean[] {false, false, false};
    		for(int j = 0; j < index.size(); j++) {
    			leaderboard[index.get(j)] = true;
    		}
    		
    		System.out.println("t " + Arrays.toString(temp));
    		System.out.println("l " + Arrays.toString(leaderboard));
    		
    		System.out.println();

    		if(!Arrays.equals(temp, leaderboard)) ans++;
    	}
    	
    	System.out.println(ans);
    }
}
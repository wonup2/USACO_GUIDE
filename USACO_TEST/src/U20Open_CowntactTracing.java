import java.util.*;
import java.io.*;

public class U20Open_CowntactTracing {
	
	static Scanner in;
	static PrintWriter out;
	static int N, T, t, x[], y[];
	static String s;
	static boolean status[];

	  
	
	public static void main(String[] args) throws IOException{	  
	  
	  in = new Scanner(new File("tracing.in"));
	  out = new PrintWriter(new File("tracing.out"));
	  init();
	  solve();
	}

	static void init() {		
		
		N = in.nextInt();
		T = in.nextInt();
		s = in.next();
		
		status = new boolean[101];
		x = new int[251];
		y =new int[251]; 

		for (int i=1; i<=N; i++)
			status[i] = s.charAt(i-1)=='1';
		 
		for (int i=0; i<T; i++) {
		   t = in.nextInt();
		   x[t] = in.nextInt();
		   y[t] = in.nextInt();		  
		}	
	}
	static void solve() {
	  
	  HashSet<Integer> possible_zero = new HashSet<Integer>();
	  int minK=250, maxK=0;

	  for (int i=1; i<=N; i++)
	    for (int k=0; k<=251; k++)
	      if (check(i, k)) {
	    	  possible_zero.add(i);
	    	  maxK = Math.max(maxK, k);
			  minK = Math.min(minK, k);
		  }

	 
	  out.print(possible_zero.size() + " " + minK + " ");
	  if (maxK==251) out.println("Infinity");
	  else out.println(maxK);
	  
	  out.close();
	 
	}
	
	
	static boolean check(int z, int k){
		
	  boolean infected[] = new boolean[101];
	  int hs[] = new int[101];
	  infected[z] = true;
	  
	  for (int t=0; t<=250; t++) {
		  
	    int a = x[t],  b= y[t];
	    if(a==0) continue;
	    
	    if (infected[a]) hs[a]++;
	    if (infected[b]) hs[b]++;
	    if (hs[a] <= k && infected[a]) infected[b] = true;
	    if (hs[b] <= k && infected[b]) infected[a] = true;
	    
	  }
	    
	  return Arrays.equals(infected, status);
	    		
	}
}
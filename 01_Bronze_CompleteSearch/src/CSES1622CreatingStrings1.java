import java.util.*;

public class CSES1622CreatingStrings1 {

	static Scanner in;
	public static void main(String[] args) {
	
		in = new Scanner(System.in);
		char c[] = in.next().toCharArray();
		TreeSet<String> set = new TreeSet<String>();
		int n = 5;
		for(int i = 0; i < n; i++) {			
			for(int j = 0; j < n; j++) {				
				if(j == i) continue;					
				for(int k = 0; k < n; k++) {					
					if(k == i || k == j) continue;						
					for(int l = 0; l < n; l++) {						
						if(l == i || l == j || l == k) continue;	
						for(int m = 0; m < n; m++) {						
							if(m == i || m == j || m == k || m==l) continue;	
							set.add(""+c[i]+c[j]+c[k]+c[l]+c[m]);	
						}
					}
				}
			}
		}			
		
		StringBuilder sb = new StringBuilder();
		for(String s:set)
			sb.append(s).append("\n");
		System.out.println(set.size());
		System.out.print(sb.toString());
	}
}


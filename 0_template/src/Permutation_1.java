
public class Permutation_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int n = 3;
		
		//permutation ();
		permutation("", n);
	}

	static void permutation(String s,  int n) {
		if(s.length()==n) System.out.println(s);
		
		for(int i=1; i<=n; i++) {
			if(!s.contains(i+"")) permutation(s+i, n);
		}
	}
	static void permutation () {
		
		for(int a=1; a<=4; a++) {
			for(int b=1; b<=4; b++) {
				if(a==b) continue;
				
				for(int c = 1; c<=4; c++) {
					if(a==c || b==c) continue;
					
					for(int d = 1; d<=4; d++) {
						if(a==d||b==d||c==d) continue;
						
						System.out.println(""+a+b+c+d);
					}
				}
			}
		}
	}
}

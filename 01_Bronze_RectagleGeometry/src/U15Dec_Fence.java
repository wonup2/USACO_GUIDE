import java.util.Scanner;

public class U15Dec_Fence {
	static Scanner in;
	static boolean a[];
	
	public static void main(String[] args) {
		in = new Scanner(System.in);

		a = new boolean[101];
		
		for(int i=0; i<2; i++) {
			int s = in.nextInt();
			int e = in.nextInt();
			
			for(int j=s; j<e; j++) a[j]=true;
		
		}
		
		int cnt = 0;
		for(int j=0; j<=100; j++) 
			if(a[j]) cnt++;
		
		System.out.println(cnt);
	}

}

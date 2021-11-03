import java.util.Scanner;

//Legendre's formula-
//https://en.wikipedia.org/wiki/Legendre%27s_formula
//https://artofproblemsolving.com/wiki/index.php/Legendre%27s_Formula


public class CSES1618 {
	static Scanner in;
	static int n, ans;
	public static void main(String[] args) {

		in = new Scanner(System.in);
		n = in.nextInt();
		ans = 0;
		while(n>0) {
			n=n/5;
			ans+=n;
		}
		
		System.out.println(ans);
	}
}

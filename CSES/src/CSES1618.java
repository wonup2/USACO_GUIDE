import java.util.Scanner;

//팩토리얼에서 뒤에 나오는 0의 갯수는 N보다 작은 수중에서 곱해지는 5나 5의 거듭제곱수들이 몇번인가와 같다. 
//그래서, 5로 계속 나누면서 나오는 수들을 누적해서 출력한다. 
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

import java.util.*;
import java.io.*;

public class U17US_TheLostCow {

	public static void main(String[] args) throws Exception {

		Scanner stdin = new Scanner(new File("lostcow.in"));
		int x = stdin.nextInt();
		int y = stdin.nextInt();

		int total = 0, start = x, mult = 1, end=0;

		while (true) {

			int current = start;
			int next = x + mult;
			int min = Math.min(current,next);
			int max = Math.max(current,next);

			if (inbetween(min, y, max)) {
				total += Math.abs(y-current);
				break;
			}

			int travel = max-min;
			total += travel;
			mult *= (-2);
			start = next;
			
		}

		PrintWriter out = new PrintWriter(new FileWriter("lostcow.out"));
		out.println(total);
		out.close();
		stdin.close();
	}

	public static boolean inbetween(int a, int b, int c) {
		return a <= b && b <= c;
	}
}
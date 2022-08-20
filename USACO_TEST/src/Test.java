import java.util.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> [][] a = new ArrayList[3][3];
		
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				a[i][j] = new ArrayList<Integer>();
		
		a[0][0].add(10);
		a[0][0].add(20);
		a[0][0].add(30);

		
		System.out.println(Arrays.deepToString(a));
		
	}

}

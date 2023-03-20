import java.io.*;
import java.util.*;

public class Grid_Input {
	private static int[][] grid;
	private static int rowNum;
	private static int colNum;
	public static void main(String[] args) throws IOException {
		BufferedReader read =
		    new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer dims = new StringTokenizer(read.readLine());
		rowNum = Integer.parseInt(dims.nextToken());
		colNum = Integer.parseInt(dims.nextToken());
		grid = new int[rowNum][colNum];
		for (int r = 0; r < rowNum; r++) {
			grid[r] = Arrays.stream(read.readLine().split(" "))
			              .mapToInt(Integer::parseInt)
			              .toArray();
		}
		
		System.out.println(Arrays.deepToString(grid));
	}
}

/*

3 4
1 1 2 1
2 3 2 1
1 3 3 3

*/
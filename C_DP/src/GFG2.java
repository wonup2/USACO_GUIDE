import java.io.*;
import java.util.Arrays; 
  
public class GFG2 { 
	
	static void print(int[][] a) {
		for(int i=0; i<a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
		System.out.println();
	}
  
    // Returns optimal value possible 
    // that a player can collect from 
    // an array of coins of size n. 
    // Note than n must be even 
    static int optimalStrategyOfGame(int arr[], int n) 
    { 
        // Create a table to store 
        // solutions of subproblems 
        int table[][] = new int[n][n]; 
        int gap, i, j, x, y, z; 
  
        // Fill table using above recursive formula. 
        // Note that the tableis filled in diagonal 
        // fashion (similar to http:// goo.gl/PQqoS), 
        // from diagonal elements to table[0][n-1] 
        // which is the result. 
        
        print(table);
        for (gap = 0; gap < n; ++gap) { 
            for (i = 0, j = gap; j < n; ++i, ++j) { 
  
                // Here x is value of F(i+2, j), 
                // y is F(i+1, j-1) and z is 
                // F(i, j-2) in above recursive formula 
                x = ((i + 2) <= j) ? table[i + 2][j] : 0; 
                y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0; 
                z = (i <= (j - 2)) ? table[i][j - 2] : 0; 
                			System.out.println(i+" "+j +" "+x+" "+y+" "+z +" "+arr[i]+" "+ arr[j]);
                			System.out.println(arr[i] + Math.min(x, y) +" "+ (arr[j] + Math.min(y, z)));
                			
                table[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z)); 
                
                			print(table);

            } 
        } 
  
        return table[0][n - 1]; 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        int arr1[] = { 8, 15, 3, 7 }; 
        int n = arr1.length; 
        System.out.println( 
            "" + optimalStrategyOfGame(arr1, n)); 
  /*
        int arr2[] = { 2, 2, 2, 2 }; 
        n = arr2.length; 
        System.out.println( 
            "" + optimalStrategyOfGame(arr2, n)); 
  
        int arr3[] = { 20, 30, 2, 2, 2, 10 }; 
        n = arr3.length; 
        System.out.println( 
            "" + optimalStrategyOfGame(arr3, n)); 
            */
    } 
} 
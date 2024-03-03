// Java code to implement the approach
// Time complexity: O(n^2) / Auxiliary Space: O(n^2)
import java.util.*; 
  
public class GFG { 
    static ArrayList<Integer> arr = new ArrayList<>(); 
    static HashMap<ArrayList<Integer>, Integer> memo 
        = new HashMap<>(); 
    static int n = 0; 
  
    // recursive top down memoized solution 
    static int solve(int i, int j) 
    { 
        if ((i > j) || (i >= n) || (j < 0)) 
            return 0; 
  
        ArrayList<Integer> k = new ArrayList<Integer>(); 
        k.add(i); 
        k.add(j); 
        if (memo.containsKey(k)) 
            return memo.get(k); 
  
        // if the user chooses ith coin, the opponent can 
        // choose from i+1th or jth coin. if he chooses 
        // i+1th coin, user is left with [i+2,j] range. if 
        // opp chooses jth coin, then user is left with 
        // [i+1,j-1] range to choose from. Also opponent 
        // tries to choose in such a way that the user has 
        // minimum value left. 
        int option1 = arr.get(i) 
                      + Math.min(solve(i + 2, j), 
                                 solve(i + 1, j - 1)); 
  
        // if user chooses jth coin, opponent can choose ith 
        // coin or j-1th coin. if opp chooses ith coin,user 
        // can choose in range [i+1,j-1]. if opp chooses 
        // j-1th coin, user can choose in range [i,j-2]. 
        int option2 = arr.get(j) 
                      + Math.min(solve(i + 1, j - 1), 
                                 solve(i, j - 2)); 
  
        // since the user wants to get maximum money 
        memo.put(k, Math.max(option1, option2)); 
        return memo.get(k); 
    } 
  
    static int optimalStrategyOfGame() 
    { 
  
        memo.clear(); 
        return solve(0, n - 1); 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        arr.add(8); 
        arr.add(15); 
        arr.add(3); 
        arr.add(7); 
        n = arr.size(); 
        System.out.println(optimalStrategyOfGame()); 
  
        arr.clear(); 
        arr.add(2); 
        arr.add(2); 
        arr.add(2); 
        arr.add(2); 
        n = arr.size(); 
        System.out.println(optimalStrategyOfGame()); 
  
        arr.clear(); 
        arr.add(20); 
        arr.add(30); 
        arr.add(2); 
        arr.add(2); 
        arr.add(2); 
        arr.add(10); 
        n = arr.size(); 
        System.out.println(optimalStrategyOfGame()); 
    } 
} 
  
// This code is contributed by phasing17
package CODEQUEST;

//2015

import java.io.*;
import java.util.*;

public class Prob06 {
    static Scanner in;
    static final int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static final int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    
    static char[][] a;
    static String word;
    
    public static void main(String[] args) {
        in = new Scanner(System.in);
        init();
    }
    
    static void init() {            
        int T = in.nextInt(); in.nextLine();            
        while (T-- > 0) solve();  
    }
    
    static void solve() {
    	 
        a = new char[in.nextInt()][in.nextInt()];  in.nextLine();             
        for (int r=0; r<a.length; r++) 
            a[r] = in.nextLine().replace(" ", "").toCharArray();
          
        int N = in.nextInt(); in.nextLine();
        
        while (N-- > 0) {
        	word = in.nextLine();
            
            here:
            for (int r=0; r<a.length; r++) {
                for (int c=0; c<a[r].length; c++) {
                    if (dfs(r, c, 0)) {
                        System.out.println(word);
                        break here;
                    }
                }
            }
        }
    }
    
    static boolean dfs(int r, int c, int index) {
            
    	if (word.charAt(index) != a[r][c]) return false;
    	
        if (index+1 == word.length()) return true;
             
        for (int i=0; i<8; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
            	
            if(nr<0||nc<0||nr>=a.length||nc>=a[0].length) continue;
            	
            if (dfs(nr, nc, index+1)) return true;
        }      
        
        return false;            
    }
}

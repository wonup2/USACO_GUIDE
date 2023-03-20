import java.io.*;
import java.util.*;
 
public class U22US_liars{
	static Scanner in;
	static pair[] a;
	
	static class pair {
        char x;
        int y;
 
        pair(char a, int b) {
            x = a;
            y = b;
        }
    }
	
    public static void main(String[] args) throws IOException {
        in = new Scanner(System.in);
        int n = in.nextInt();
        a = new pair[n];
        
        for (int j = 0; j < n; j++) 
            a[j] = new pair(in.next().charAt(0), in.nextInt());
        
        int ans = n;
        for (pair cur : a) {           
            int liars = 0;
            for (pair next : a) 
                if (next.x == 'G' ? cur.y < next.y : cur.y > next.y) liars++;                
            
            ans = Math.min(ans, liars);
        }
        
        System.out.println(ans);
    }   
}
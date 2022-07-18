import java.util.*;
import java.io.*;

public class CSES2205 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(grayCode(in.nextInt()));
	}
	
	public static ArrayList<Integer> grayCode(int n) {
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        if(n <= 1){
	            res.add(0);
	            if(n == 1)
	                res.add(1);
	            return res;
	        }
	        ArrayList<Integer> prev = grayCode(n - 1);
	        int highest_bit = 1 << (n - 1);
	        for(int i = prev.size() - 1; i >= 0; i--)
	            res.add(prev.get(i) + highest_bit);
	        prev.addAll(res);
	        return prev;
	    }

}

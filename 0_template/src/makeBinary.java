import java.util.*;

public class makeBinary {

	public static void main(String[] args) {

		int n = 5;
		
		String bin = Integer.toBinaryString(n);
		System.out.println(bin);
		
		bin = dtob(n);
		System.out.println(bin);
		
		bin = (1<<n) + "";
		System.out.println(bin);
	}
	
	static String dtob(int n)
    {
        if (n == 0) return "";
             
        else return dtob(n/2) + (n % 2) ;
    }
	
}

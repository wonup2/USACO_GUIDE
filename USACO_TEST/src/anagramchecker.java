import java.util.*;
import java.io.*;

public class anagramchecker {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for(int i=0; i<n; i++) {
			
			String s = in.nextLine();
			String s1 = s.substring(0, s.indexOf("|"));
			String s2 = s.substring(s.indexOf("|")+1);
			char a1[] = s1.toCharArray();
			char a2[] = s2.toCharArray();
			
			Arrays.sort(a1);
			Arrays.sort(a2);
			
			if(s1.equals(s2)) System.out.println(s + " = NOT AN ANAGRAM");
			else if (Arrays.equals(a1, a2)) System.out.println(s + " = ANAGRAM");
			else System.out.println(s + " = NOT AN ANAGRAM");
		}

	}

}
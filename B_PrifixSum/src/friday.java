/*
ID: wonup22
LANG: PYTHON2
TASK: friday
*/

import java.io.*;
import java.util.*;

public class friday {
  public static void main (String [] args) throws IOException {
    Scanner in = new Scanner(new File("friday.in"));
    PrintWriter out = new PrintWriter(new File("friday.out"));
    
    int date[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int n = in.nextInt();
    int day = 13;
    int ans[] = new int[7];

    for(int i=1900; i<1900+n; i++) {  	
    	
    	for(int j=1; j<=12; j++) {
    		
        	ans[day%7]++;
        	day += date[j];
        	
    		if(j==2 && leap(i)) day++;
    	}
    }

    System.out.println(Arrays.toString(ans));

    out.close();                                  // close the output file
    
  }
  
  
  static boolean leap(int year) {
	  return year%400==0 || (year%4==0 && year%100!=0);
  }
}

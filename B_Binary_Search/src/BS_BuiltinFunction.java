import java.util.*;

//binarySearch method
//lower bound
//upper bound


public class BS_BuiltinFunction {

	public static void main(String[] args) {
		
		int[] a = {1, 10, 10, 10, 10, 10, 10, 19};
		
		Arrays.sort(a);
		
		//System.out.println(Arrays.toString(a));  	//{1,3,4,10,19};		
				
		int n = Arrays.binarySearch(a, 10);		//3				
		//System.out.println(n);
		
		
		
		n = Arrays.binarySearch(a, 11);   		// -5 { 1, 3, 4, 10, <11>, 19 } 	
		
		
		//a = { 1, 3, 4, 10, <11>, 19 } 
		int lower = Math.abs(n) - 2;  			//lower bound: 10
		
		int upper = Math.abs(n) - 1;  			//upper bound: 19
		
		//System.out.println(a[lower] +" "+ a[upper]);
		
		
		
		
		
		
		
		
		
		
		/*
		 USACO 2016 December Contest, Silver Problem 1. Counting Haybales
		 http://www.usaco.org/index.php?page=viewproblem2&cpid=666
		*/
		
		

		int[] b = {2,3,4,10,10,19};
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		
		tm.put(2, 0);
		tm.put(3, 1);
		tm.put(4, 2);
		tm.put(10, 3);
		tm.put(19, 5);
		
		lower = tm.lowerKey(10);
		System.out.println(lower);			//4
		System.out.println(tm.get(lower));	//2
		
		upper = tm.higherKey(5);			
		System.out.println(upper);			//19
		System.out.println(tm.get(upper));	//5
		
		/*
		https://www.acmicpc.net/problem/10816
		https://cses.fi/problemset/task/1091
		https://cses.fi/problemset/task/1163
		*/
	}
}
import java.util.*;

public class B9935 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String bomb = in.nextLine();

	    int slen = str.length();
	    Stack<Character> result = new Stack<Character>();
	    
	    for(int i=0; i<slen; i++) {
	    	result.add(str.charAt(i)); 
	    	//System.out.println(result);
			int j= bomb.length()-1;
			        
			if(str.charAt(i) == bomb.charAt(j)) {			
			   // System.out.println(str.charAt(i)+" "+bomb.charAt(j));
			    
				for(int k=bomb.length()-1; k>=0; k--){
					System.out.println(result.peek()+" "+bomb.charAt(j));
			                
					if(result.peek() == bomb.charAt(j)) 
						result.pop();
			        else break;
			        
				}				
			}	
		}
	    
	    if(result.isEmpty())
	        System.out.println("FRULA");
	    else			    
	        for(char c:result)
	          System.out.print(c);
	}
}

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		//get data
		System.out.print("How old are you? ");
		int age = in.nextInt();  
		in.nextLine();		//<-----------------------------
				
		System.out.print("What is you name? ");
		String name = in.nextLine();		
		
		
		//display
		System.out.println("I am " + age + " years old");
		System.out.println("My name is " + name);	

	}
}

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		System.out.print("Input two integer number :");
		int num1 = in.nextInt();
		int num2 = in.nextInt();
		
		System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
		
		
		System.out.print("Input two double number :");
		double d1 = in.nextDouble();
		double d2 = in.nextDouble();
		
		System.out.println(d1 + " + " + d2 + " = " + (d1+d2));
		
		System.out.print("Input your first name and last name: ");
		String s1 = in.next();
		String s2 = in.next();
		
		System.out.println("My name is " + s1 + " " + s2);
		
	}

}

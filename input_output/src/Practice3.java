import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		System.out.print("Type your age: ");
		
		while(!in.hasNextInt()) {
			in.nextLine();
			System.out.print("Type your age: ");
		}
		
		int age = in.nextInt();
		in.nextLine();
		System.out.println("You are " + age + " years old");
		
		
		
		System.out.print("Type your GPA: ");
		
		while(!in.hasNextDouble()) {
			in.nextLine();
			System.out.print("Type your GPA: ");
		}
		double gpa = in.nextDouble();
		System.out.println("You GPA is " + gpa);
		
		
		
	}

}

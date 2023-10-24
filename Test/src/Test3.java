class Father{
	void me() {
		System.out.println("I am a Father");
	}
}

class Son extends Father{
	void me(){
		System.out.println("I am a Son");
	}
}

public class Test3 {

	public static void main(String[] args) {

		Father a = new Father();  	//a is a Father and type is Father
		Father b = new Son(); 		//b is a Dog and type is Animal
		
		a.me();	//I am a Father
		Father d = (Son)b;	
		b.me();	//I am a Son
		d.me();	//I am a Son
		System.out.println(d.getClass());
		System.out.println(b.getClass());

		d = a;
		d.me();	//I am a Father
		System.out.println(a.getClass());
		System.out.println(d.getClass());

	}
}

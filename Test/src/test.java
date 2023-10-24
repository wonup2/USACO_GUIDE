
interface Interface{
	
	public int method();
}

class Class implements Interface{
	
	public int method() {
		return 1;
	}
}

public class test {

	public static void main(String[] args) {
		
		Interface c = new Class(); 
	}

}

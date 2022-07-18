
public class staticClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class pair1{
		int a, b;
		
		pair1(int x, int y){
			a = x;
			b = y;
		}
		
		public String toString() {
			return a+" "+b;
		}
	}
	
	
	static class pair2 implements Comparable<pair2>{
		int a, b;
		
		pair2(int x, int y){
			a = x;
			b = y;
		}
		
		public String toString() {
			return a+" "+b;
		}

		@Override
		public int compareTo(pair2 that) {
			return this.a-that.a;
		}
	}
}

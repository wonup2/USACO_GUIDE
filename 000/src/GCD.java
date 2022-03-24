
public class GCD {

	public static void main(String[] args) {

		int n = 9;
		int m = 18;
		System.out.println(gcd(n, m));
	}
	
	static int gcd(int a, int b){
	    int tmp, n;
	 
	//a에 큰 값을 위치시키기 위한 조건문입니다.
	    if(a<b){
	        tmp = a;
	        a = b;
	        b = tmp;
	    }
	    
	//유클리드 알고리즘 부분입니다.
	//b가 0이 될때까지(a%b), 반복문을 돌게되고, b가 0인 순간의 a를 GCD로 판단하고 리턴합니다.
	    while(b!=0){
	        n = a%b;
	        a = b;
	        b = n;
	    }
	    return a;
	}
	
	
	int gcd_e(int a, int b){
	    
	    if(b == 0){
	        return a;
	    }else{
	        return gcd(b, a%b);
	    }
	}
}

import java.util.*;

public class BIT {

	private long[] tree;
	
	public BIT(int size) {
		tree = new long[size];
	}
	
	public BIT(long[] a) {
		if(a==null) 
			throw new IllegalArgumentException("error");
		
		this.tree = a.clone();
		
		for(int i=1; i<tree.length; i++) {
			int j = i + lsb(i);
			if(j<tree.length) tree[j] += tree[i];
		}
		
		//System.out.println(Arrays.toString(tree));
	}
	public int lsb(int i) {
		return i & -i;  //the last 1's position
	}
	
	public long prefixSum(int i) {
		long sum = 0;
		while(i != 0) {
			sum += tree[i];
			i -= lsb(i);
		}
		
		return sum;
	}
	
	public long sum(int i, int j) {
		return prefixSum(j) - prefixSum(i-1);
	}
	
	public void add(int i, long k) {
		while(i < tree.length) {
			tree[i] += k;
			i += lsb(i);
		}
	}
	
	public void set(int i, long k) {
		add(i, k-tree[i]);
	}
	public String toString() {
		return Arrays.toString(tree);	
	}
	
	public static void main(String[] args) {

		long a[] = {0, 3, 4, -2, 7, 3, 11, 5, -8, -9, 2, 4, -8};
		
		BIT b = new BIT(a);
		System.out.println(b);
		
		System.out.println(b.prefixSum(a.length-1));
		System.out.println(b.sum(2, 5));
		
		b.add(5,  7); 		
		System.out.println(b.sum(1, a.length-1));

		b.set(5,  7);
		System.out.println(b);
		System.out.println(b.sum(1, a.length-1));

	}
	
}

import java.util.PriorityQueue;

public class PQ {

	public static void main(String[] args) {
		
		PriorityQueue <Integer> pq = new PriorityQueue<Integer>();

		pq.add(1);
		pq.add(10);
		pq.add(4);
		pq.add(11);
		pq.add(15);
		pq.add(21);
		pq.add(31);
		
		System.out.println(pq);		
		System.out.println(pq.peek());		
		System.out.println(pq);
		System.out.println(pq.poll());
		System.out.println(pq);

	}

}

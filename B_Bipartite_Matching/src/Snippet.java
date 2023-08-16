import java.util.*;

public class Snippet {
	
	static int h, c;
	static boolean a[][]; 	//인접 행렬로 표현한 (이분)그래프
	static boolean visited[] ;
	static int[] hs, cs; 	//각 정점에 매칭된 상대의 정점 번호 지정
	
	static boolean dfs(int s)
	{
		if (visited[s])
			return false;
	
		visited[s] = true;
	
		for (int i = 0; i < c; i++) //회사를 확인하여
		{
			if (a[s][i]) //구직자가 선호하는 회사라면
			{
				System.out.print(s+" "+i + " " + Arrays.toString(visited) +" ");
				//만약에 매칭되어 있지 않다면 구직자와 회사를 매칭.
				//만약에 매칭되어 있다면, 기존에 매칭된 구직자를 종용(?) 한다.
				if (cs[i] == -1 || dfs(cs[i])){
					hs[s] = i;
					cs[i] = s;
					System.out.println(true);
					return true;
				}
			}
		}
		System.out.println(false);

		return false;
	}
	
	static int bipartiteMatch()
	{
		//초기화는 아무 정점과도 매칭안된 것을 의미하는 -1. 
		hs = new int[h];
		Arrays.fill(hs, -1);
		cs = new int[c];
		Arrays.fill(cs, -1);	
	
		int size = 0;
		for (int start = 0; start < h; start++) //구직자 입장에서 출발
		{
			visited = new boolean[h];
			
			if (dfs(start))
				size++;
			
			System.out.println(Arrays.toString(cs));
			System.out.println(Arrays.toString(hs));

		}
		return size;
	}
	
	public static void main(String[] args){
		h = 3; // 구직자 수
		c = 3; // 회사 수
	
		// A의 정점i와 B의 정점 j가 연결되어 있으면 1로 표시.
		a = new boolean[h][c];
		a[0][0] = true; 
		a[0][1] = true;
		a[0][2] = true;
		   
		a[1][0] = true;
		   
		a[2][1] = true;
	
		System.out.println(bipartiteMatch());	
	}
}
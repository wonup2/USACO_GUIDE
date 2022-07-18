import java.io.*;
import java.util.*;

public class Subordinates
{
	static Scanner in = new Scanner(System.in);

	public static final int MN = 200020;

	static int N, M, ans;
	static int[] hd = new int[MN], nx = new int[MN], to = new int[MN], s = new int[MN], p = new int[MN];

	public static void adde(int u, int v, int id)
	{
		nx[id] = hd[u];
		hd[u] = id;
		to[id] = v;
	}
	public static void dfs(int node)
	{
		s[node]=1;
		for(int id=hd[node];id!=0;id=nx[id])
		{
			dfs(to[id]);
			s[node]+=s[to[id]];
		}
	}
	public static void main(String... args)
	{
		N=in.nextInt();
		for(int i=2;i<=N;++i)
		{
			p[i]=in.nextInt();
			adde(p[i], i, i);
		}
		dfs(1);
		for(int i=1;i<=N;++i)
		{
			System.out.print(s[i]-1);
			if(i<N) System.out.print(" ");
			else System.out.println();
		}
	}
}

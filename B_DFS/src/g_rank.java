import java.util.*;
import java.io.*;
import java.lang.*;

public class g_rank {
    static ArrayList<Integer>[] a;
    static boolean[] v;
    static int start = 0;
    static boolean[] cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        a = new ArrayList[n];

        v = new boolean[n];
        cycle = new boolean[n];
        for (int i = 0; i < n; i++) 
            a[i] = new ArrayList<Integer>(); 
    
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int sa = Integer.parseInt(st.nextToken());
            int sb = Integer.parseInt(st.nextToken());
            if (sa > sb) a[x].add(y);
            else a[y].add(x);            
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(v, false);
            start = i;
            dfs(i);
        }

        int ans = 0;
        for (boolean c : cycle) if (c) ans++;        

        System.out.println(ans);
    }

    public static void dfs(int i) {
    	
        v[i] = true;
        
        for(int next : a[i]) {
            if (next == start) cycle[start] = true;            
            if(!v[next]) dfs(next);            
        }
    }
}
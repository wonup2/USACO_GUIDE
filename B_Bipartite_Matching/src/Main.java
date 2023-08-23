import java.io.*;
import java.util.*;
 
public class Main{
    public static long mod = (long)1e9+7;
    public static ArrayList<Integer>[] graph;
    public static void sort(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for(int u:arr) list.add(u);
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
    public static void sort(long[] arr){
        ArrayList<Long> list = new ArrayList<>();
        for(long u:arr) list.add(u);
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
    public static void main(String[] args) {
        InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
        int t = 1;
        t = in.nextInt();
        for(int i = 1;i<=t ;i++){
            solve(in,out);
        }
        out.close();
    }
    static boolean[] visited;
    static StringBuilder res;
    static int[] color;
    static boolean flag;
    private static void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        graph = new ArrayList[n];
        Arrays.setAll(graph, a -> new ArrayList<>());
        color =  new int[n];
        Arrays.fill(color, -1);
        visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            u--;v--;
            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(0,0);
        StringBuilder res = new StringBuilder();
        StringBuilder res1 = new StringBuilder();

        long cnt = 0;
        long cnt1 = 0;

        for(int i = 0;i<color.length;i++){
            if(color[i]==0){
                cnt++;
                res.append(i+1).append(" ");
            }
            else{
                cnt1++;
                res1.append(i+1).append(" ");
            }
        }
        
		//System.out.println(res);
		//System.out.println(res1);
		
        if(cnt <= n/2){
            out.println(cnt);
            out.println(res);
        }
        else{
            out.println(cnt1);
            out.println(res1);
        }
    }
    private static void dfs(int i,int clr) {
        visited[i] = true;
        color[i] = clr;
        for(int u:graph[i]){
            if(visited[u]){
                continue;
            }
            dfs(u,1-clr);
        }
    }
}
class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;
 
    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }
 
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
 
    public int nextInt() {
        return Integer.parseInt(next());
    }
 
    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble(){
        return Double.parseDouble(next());
    }
    public int[] readIntArray(int size){
        int[] list = new int[size];
        for(int i = 0;i<size;i++) list[i] = nextInt();
        return list;
    }
    public long[] readLongArray(int size){
        long[] list = new long[size];
        for(int i = 0;i<size;i++) list[i] = nextLong();
        return list;
    }
    public double[] readDoubleArray(int size){
        double[] list = new double[size];
        for(int i = 0;i<size;i++) list[i] = nextDouble();
        return list;
    }
    public String linereader() {
        String s = null;
        try{
            s = reader.readLine();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return s;
    }
 
}
class Pair<T extends Comparable<T>,K extends Comparable<K> > implements Comparable<Pair<T,K>>{
    T first;
    K second;
    public Pair(T first, K second){
        this.first  = first;
        this.second = second;
    }
    @Override
    public String toString(){
        return first+" "+second;
    }
    @Override
    public int compareTo(Pair<T,K> o) {
        // TODO Auto-generated method stub
        if((first).compareTo(o.first)!=0) return first.compareTo(o.first);
        else return second.compareTo(o.second);
    }
 
}
package USACO;
//USACO 2019 January Contest, Silver Problem 2. Icy Perimeter
import java.io.*;
import java.util.*;

public class JAN_SIL_perimeter {
	
	static BufferedReader in;
	static PrintWriter out;
	static int n;
	static int cnt, Mcnt, per, Mper;
	static char[][] a;
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("perimeter.in"));
		out = new PrintWriter(new FileWriter("perimeter.out"));
		init();
		solve();
	}
	
	static void init() throws IOException {
		
		n = Integer.parseInt(in.readLine());		
		a = new char[n][];
		
		for(int r = 0; r < n; r++) 
			a[r]=in.readLine().toCharArray();				
	}
	
	static void solve() {
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				if(a[r][c]=='#') {
					cnt = 0;
					per = 0;
					floodfill(r, c);

					if(Mcnt==cnt)	Mper = Math.min(Mper, per);
					else Mper = Math.max(Mper, per);
					
					Mcnt = Math.max(Mcnt, cnt);
				}
			}
		}
		
		out.println(Mcnt + " " + Mper);
		out.close();
	}
	
	
	public static void floodfill (int x, int y) {
        if(x<0 || x>=n || y<0 || y>=n) {
        	per++; 
            return;
        }
        if(a[x][y]=='.') {
        	per++;
            return;
        }
        if(a[x][y]=='$') return;
            
        a[x][y]='$';
        cnt++;   
        
        floodfill(x, y+1);
        floodfill(x, y-1);
        floodfill(x+1, y);
        floodfill(x-1, y);        
    }
	
	
	public static void printBoard(String[][] grid) {
		for (int i = 0; i < grid.length; i++) {
		    for (int j = 0; j < grid[i].length; j++) {
		        System.out.print(grid[i][j] + " ");
		    }
		     System.out.println();
		}
	}	
}

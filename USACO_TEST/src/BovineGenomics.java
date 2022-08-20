import java.io.*;
import java.util.*;

public class BovineGenomics {
	public static void main (String[] args) throws IOException {
		Kattio io = new Kattio("test");
	
		int cowNum = io.nextInt();
		int genomeLen = io.nextInt();
		String genome="";
		
		int[][] spotted = new int[cowNum][genomeLen];
		for (int s = 0; s < cowNum; s++) {
			genome = io.next();
			for (int g = 0; g < genomeLen; g++) {
				// A -> 0, C -> 1, T -> 2, G -> 3
				if (genome.charAt(g) == 'A') {
					spotted[s][g] = 0;
				} else if (genome.charAt(g) == 'C') {
					spotted[s][g] = 1;
				} else if (genome.charAt(g) == 'T') {
					spotted[s][g] = 2;
				} else if (genome.charAt(g) == 'G') {
					spotted[s][g] = 3;
				}
			}
		}

		int[][] plain = new int[cowNum][genomeLen];
		for (int p = 0; p < cowNum; p++) {
			genome = io.next();
			for (int g = 0; g < genomeLen; g++) {
				if (genome.charAt(g) == 'A') {
					plain[p][g] = 0;
				} else if (genome.charAt(g) == 'C') {
					plain[p][g] = 1;
				} else if (genome.charAt(g) == 'T') {
					plain[p][g] = 2;
				} else if (genome.charAt(g) == 'G') {
					plain[p][g] = 3;
				}
			}
		}

		System.out.println(Arrays.deepToString(spotted));
		System.out.println(Arrays.deepToString(plain));

		int validSets = 0;

		// Loop through every possible group of 3.
		for (int a = 0; a < genomeLen; a++) {
			for (int b = a + 1; b < genomeLen; b++) {
				for (int c = b + 1; c < genomeLen; c++) {
					boolean[] spottedIDs = new boolean[64];
					for (int sc = 0; sc < cowNum; sc++) {
						/*
						 * By multiplying the first, second, and
						 * third digits by 16, 4, and 1 respectively, we can
						 * get a number unique to that combination.
						 */ 
						int total = (
							spotted[sc][a] * 16
							+ spotted[sc][b] * 4
							+ spotted[sc][c] * 1
						);
						spottedIDs[total] = true;
					}

					boolean valid = true;
					for (int pc = 0; pc < cowNum; pc++) {
						int total = (
							plain[pc][a] * 16
							+ plain[pc][b] * 4
							+ plain[pc][c] * 1
						);
						// We can't tell the spotted & plain cows apart.
						if (spottedIDs[total]) {
							valid = false;
							break;
						}
					}

					validSets += valid ? 1 : 0;
				}
			}
		}

		io.println(validSets);
		io.close();
	}

	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
		// standard input
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(problemName + ".out");
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}
		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
}
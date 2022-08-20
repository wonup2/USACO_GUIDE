import java.util.*;
import java.io.*;

public class bronzeopen1bucketbrigade {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;    
    static String f = "test";
    static int br, bc, lr, lc, rr, rc;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new FileReader(f+".in"));
        out = new PrintWriter(new FileWriter(f+".out"));
        init();
        solve();
        
        in.close();
        out.close();
    }
    
    static void init() throws IOException {
    	for(int i=0;i<10;i++) {
	    	String s=in.readLine();
	        for(int j=0;j<s.length();j++) {
	        	if(s.charAt(j)=='R') {
	        		rr=i;
	        		rc=j;
	        	}
	        	if(s.charAt(j)=='B') {
	        		br=i;
	        		bc=j;
	        	}
	        	if(s.charAt(j)=='L') {
	        		lr=i;
	        		lc=j;
	        	}
	        }
        }    	
    }
    
    static void solve() {
    	
    	int ans=0;
    	ans=Math.abs(br-lr)+Math.abs(lc-bc)-1;
    	
        if(rr==br && br==lr) {
        	if(bc<rc && lc>rc || lc<rc && bc>rc) {
        		ans+=2;
        	}
        }
        else if(rc==bc && bc==lc) {
        	if(br<rr && lr>rr || lr<rr && br>rr) {
        		ans+=2;
        	}
        }
        
        out.println(ans);
    }

}
import java.io.*;
import java.util.*;

public class CF1398_goodSubarrays {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();

            Map<Integer, Long> cnt = new HashMap<>();
            cnt.put(0, 1L); // prefix[0] = 0
            long ans = 0;
            int pref = 0;

            for (int i = 0; i < n; i++) {
                int d = s.charAt(i) - '0';
                pref += d - 1;                 // prefix[i] = Σ(a[j]-1)
                ans += cnt.getOrDefault(pref, 0L); // 같은 prefix를 얼마나 봤는지 더함
                cnt.put(pref, cnt.getOrDefault(pref, 0L) + 1);
            }
            
            System.out.println(cnt);
            out.append(ans).append('\n');
        }
        System.out.print(out);
    }
}

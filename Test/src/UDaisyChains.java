import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class UDaisyChains {
    static String file = "test";
    static Scanner in;
    static PrintWriter out;
    static int n, count;
    static float sum, avg;
    static int[] a;

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new File(file + ".in"));
        out = new PrintWriter(new File(file + ".out"));

        init();
        solve();

        in.close();
        out.close();


    }

    static void init() {

        n = in.nextInt(); in.nextLine();
        a = new int[n];
        for(int i = 0; i<n; i++) {
            a[i] = in.nextInt();
        }

        System.out.println(Arrays.toString(a));
    }


    static void solve() {
        count = 0;
        for(int s = 0; s<n; s++) {

            for(int e = s; e<n; e++) {

                sum = 0;
                for(int i = s; i<=e; i++) {

                    sum+=a[i];
                }

                avg = sum/(e-s + 1);


                for(int i = s; i<=e; i++) {

                    if(a[i]==avg) {
                      //  System.out.println(s+" "+e+" "+sum +" " + avg + " "+a[i]);

                        count++; break;
                    }
                }
            }
        }

        out.println(count);
    }

}
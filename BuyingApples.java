import java.util.Arrays;
import java.util.Scanner;

// https://www.spoj.com/problems/ABA12C/

public class BuyingApples {
    static Scanner scn;
    public static void main(String[] args) {
        scn= new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            solve();
        }
    }
    static void solve() {
        int n = scn.nextInt();
        int k = scn.nextInt();

        int[] arr = new int[k+1];
        for(int i=1; i<arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int[] dp = new int[k+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=k; i++) {
            for(int j=1; j<=k; j++) {
                if(arr[j] == -1) continue;
                else {
                    if(i >= j && dp[i-j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], arr[j] + dp[i-j]);
                    }
                }
            }
        }

        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : 0);
    }
}

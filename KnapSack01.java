import java.io.*;
import java.util.*;

public class KnapSack01 {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] val = new int[n];
        for(int i=0; i<n; i++) val[i] = scn.nextInt();

        int[] wt = new int[n];
        for(int i=0; i<n; i++) wt[i] = scn.nextInt();

        int cap = scn.nextInt();

        //int[][] dp = new int[n+1][]
        int[][] dp = new int[n+1][cap+1];

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[i].length; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= wt[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j - wt[i-1]]);
                }
            }
        }
        System.out.println(dp[n][cap]);
    }
}

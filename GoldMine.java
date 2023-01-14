import java.util.*;
public class GoldMine {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        for(int i=0; i<n; i++) {
            dp[i][m-1] = arr[i][m-1];
        }
        for(int j=m-2; j>=0; j--) {
            int val = Integer.MIN_VALUE;
            for(int i=n-1; i>=0; i--) {
                if (i == n - 1) {
                    val = Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else if (i == 0) {
                    val = Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
                } else {
                    val = Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
                }
                val += arr[i][j];
                dp[i][j] = val;
            }
        }

        for(int i=0; i<dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}

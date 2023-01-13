import java.util.*;
public class MinCostInMazeTraversal {
    //https://leetcode.com/problems/minimum-path-sum/submissions/877595045/
    public void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][m];
        //dp[n-1][m-1] = arr[n-1][m-1];

        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                if(i == n-1 && j == m-1) {
                    dp[i][j] = arr[i][j];
                }
                else if(i == n-1) {
                    dp[i][j] = arr[i][j] + dp[i][j+1];
                }
                else if(j == m-1) {
                    dp[i][j] = arr[i][j] + dp[i+1][j];
                }
                else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        // for(int i=n-1; i>=0; i--) {
        //     for(int j=m-1; j>=0; j--) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(dp[0][0]);
    }
}

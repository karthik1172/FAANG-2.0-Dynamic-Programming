public class LCSOfThreeString {
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) {
        // code here
        int[][][] dp = new int[n1+1][n2+1][n3+1];
        for(int i=1; i<=n1; i++){
            for(int j = 1; j<=n2; j++){
                for(int k=1; k<=n3;k++){
                    if(A.charAt(i-1) == B.charAt(j-1) && A.charAt(i-1) == C.charAt(k-1)){
                        dp[i][j][k] = 1 + dp[i-1][j-1][k-1];
                    }
                    else{
                        int x = dp[i-1][j][k];
                        int y = dp[i][j-1][k];
                        int z = dp[i][j][k-1];
                        dp[i][j][k] = Math.max(x, Math.max(y,z));
                    }
                }
            }
        }
        return dp[n1][n2][n3];
    }
}

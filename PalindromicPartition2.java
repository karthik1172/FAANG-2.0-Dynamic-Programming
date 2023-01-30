

//https://leetcode.com/problems/palindrome-partitioning-ii/description/
public class PalindromicPartition2 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int g=0; g<n; g++) {
            for(int i=0, j=g; j<n; i++, j++){
                if(g==0){
                    dp[i][j] = true;
                }
                else if(g==1){
                    dp[i][j] = s.charAt(i)==s.charAt(j);
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
            }
        }

        int[] dp1 = new int[n];
        dp1[0] = 0;
        for(int i=1; i<n; i++){
            if(dp[0][i]){
                dp1[i]=0;
            }
            else{
                int min = Integer.MAX_VALUE;
                for(int j=i; j>=1; j--){
                    if(dp[j][i]){
                        min = Math.min(dp1[j-1], min);
                    }
                }
                dp1[i] = min + 1;
            }
        }
        return dp1[n-1];
    }
}

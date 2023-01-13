public class MinCostClimbingStairs {
    //https://leetcode.com/problems/min-cost-climbing-stairs/description/
    int [] dp = new int[10001];
    public int minCostClimbingStairs(int[] c) {
        int i=0;
        return Math.min(solve(i, c), solve(i+1, c));
    }
    int solve(int i, int[] c) {
        if(i>=c.length) return 0;
        if(dp[i]>0) return dp[i];

        else{
            int s1 = solve(i+1, c);
            int s2 = solve(i+2, c);
            return dp[i] = Math.min(s1,s2)+c[i];
        }
    }
}

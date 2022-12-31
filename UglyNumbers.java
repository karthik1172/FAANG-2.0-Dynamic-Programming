public class UglyNumbers {
    //https://leetcode.com/problems/ugly-number-ii/description/
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for(int i=1; i<n; i++) {
            int f1 = 2 * dp[p2];
            int f2 = 3 * dp[p3];
            int f3 = 5 * dp[p5];

            int min = Math.min(f1, Math.min(f2,f3));

            dp[i] = min;
            if(f1 == min) {
                p2++;
            }
            if(f2 == min) {
                p3++;
            }
            if(f3 == min) {
                p5++;
            }
        }
        return dp[n-1];
    }
}

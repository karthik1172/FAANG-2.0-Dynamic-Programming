//https://practice.geeksforgeeks.org/problems/maximum-sum-bitonic-subsequence1857/1
import java.util.*;
public class MaximumSumBitonicSubsequence {
    public static int maxSumBS(int arr[], int n)
    {
        int max_sum = Integer.MIN_VALUE;

        int MSIBS[] = new int[n];//Increasing
        int MSDBS[] = new int[n];//Decreasing

        for (int i = 0; i < n; i++) {
            MSDBS[i] = arr[i];
            MSIBS[i] = arr[i];
        }

        // Compute MSIBS values from left to right */
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j] && MSIBS[i] < MSIBS[j] + arr[i])
                    MSIBS[i] = MSIBS[j] + arr[i];

        // Compute MSDBS values from right to left
        for (int i = n - 2; i >= 0; i--)
            for (int j = n - 1; j > i; j--)
                if (arr[i] > arr[j] && MSDBS[i] < MSDBS[j] + arr[i])
                    MSDBS[i] = MSDBS[j] + arr[i];

        for (int i = 0; i < n; i++)
            max_sum = Math.max(max_sum, (MSDBS[i] + MSIBS[i] - arr[i]));

        // return max sum of bi-tonic
        // sub-sequence
        return max_sum;
    }
}

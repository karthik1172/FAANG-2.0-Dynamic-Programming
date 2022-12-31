import java.util.*;
//https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1

//Subset sum Variation
public class PartitionEqualSubsetSum {
    int equalPartition(int n, int arr[]) {
        // code here
        boolean x = true;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum = arr[i]+sum;
        }
        if(sum % 2 != 0)return 0;

        else if(sum % 2 == 0){
            x =  help(arr, sum / 2);

        }
        if(x) return 1;
        else return 0;
    }
    boolean help(int arr[], int tar) {
        int n = arr.length;
        boolean[][]  dp = new boolean[n+1][tar+1];
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<tar+1; j++) {
                if(i==0 && j==0){
                    dp[i][j]= true;
                }
                else if(i == 0) dp[i][j] = false;

                else if(j == 0) dp[i][j] = true;

                else {
                    if(dp[i-1][j] == true) dp[i][j] = true;

                    else {
                        int val = arr[i-1];
                        if(j >= val) {
                            if(dp[i-1][j] == true) dp[i][j] = true;

                            else {
                                if(dp[i-1][j-val] == true) dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return dp[n][tar];
    }
}

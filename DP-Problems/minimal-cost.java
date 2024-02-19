// Problem - link --> https://www.codingninjas.com/studio/problems/minimal-cost_8180930

import java.util.*;
public class Solution {
    public static int minimizeCost(int n, int k, int []height){
        // Write your code here.
        int [] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(n-1,height, k,dp);
    }


    static int helper(int n,int[] heights,int k,int[] dp){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];

        int min_steps = Integer.MAX_VALUE;
        for(int i =1; i <= k;i++){
            if(n-i >= 0){
                int jump = helper(n-i,heights,k,dp) + Math.abs(heights[n] - heights[n-i]);
                min_steps = Math.min(min_steps,jump);

            }else break;
        }

        return dp[n] = min_steps;
    }
}

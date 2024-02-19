// Problem Link --> https://leetcode.com/problems/climbing-stairs/

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(0,n,dp);
    }

    int helper(int st,int n,int[] dp){
        if(st == n) return 1;
        if(st > n) return 0;
        if(dp[st] != -1) return dp[st]; 
        return dp[st] = helper(st+1,n,dp)  + helper(st+2,n,dp);
    }
}


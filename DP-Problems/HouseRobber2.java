class Solution {
    public int rob(int[] nums) {
         int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
     
        int one = helper(1,n,nums,dp);
         Arrays.fill(dp,-1);
        int two = helper(0,n-1,nums,dp);
        return Math.max(one,two);
    }

    public int helper(int st,int n,int[] nums,int[] dp){
        if(st >= n) return 0;
        if(dp[st] != -1) return dp[st];

        int left = nums[st] + helper(st + 2,n,nums,dp);
        int right = helper(st + 1,n,nums,dp);

        return dp[st] = Math.max(left,right);

    }
}
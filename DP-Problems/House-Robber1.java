// Memoization (Top Down)
// Complexity
// Time complexity:O(N)

// Space complexity:O(N) + O(N)

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(0,n,nums,dp);
    }

    public int helper(int st,int n,int[] nums,int[] dp){
        if(st >= n) return 0;

        if(dp[st] != -1) return dp[st];

        int left = nums[st] + helper(st + 2,n,nums,dp);
        int right = helper(st + 1,n,nums,dp);

        return dp[st] = Math.max(left,right);
    }
}
// Tabulation (Bottom Up)
// Complexity
// Time complexity:O(N)

// Space complexity:O(N)

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int neg = 0;

        for(int i =1; i < n;i++){
            int take = nums[i];
            if(i > 1){
                take += dp[i-2];
            }

            int nottake = 0 + dp[i-1];

            dp[i] = Math.max(take,nottake);
        }

        return dp[n-1];    
    }  
}
// Space Optimization
// Complexity
// Time complexity:O(N)

// Space complexity:O(1)


class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for(int i =1; i < n;i++){
            int take = nums[i];
            if(i > 1){
                take += prev2;
            }

            int nottake = 0 + prev;
            prev2 = prev;

            prev = Math.max(take,nottake);
        }

        return prev;
       
    }

    
}

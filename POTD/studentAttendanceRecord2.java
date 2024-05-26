class Solution {
    private static final int MOD = 1000000007;

    public int checkRecord(int n) {
        int[][] dp = new int[3][4];
        int[][] prevDp = new int[3][4];

        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 2; j++) {
                prevDp[i][j] = 1;
            }
        }

        for (int day = 1; day <= n; day++) {
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 2; j++) {
                    dp[i][j] = prevDp[i][0] % MOD;
                    dp[i][j] = (dp[i][j] + prevDp[i + 1][0]) % MOD;
                    dp[i][j] = (dp[i][j] + prevDp[i][j + 1]) % MOD;
                }
            }
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 2; j++) {
                    prevDp[i][j] = dp[i][j];
                }
            }

        }

        return dp[0][0];
    }
}
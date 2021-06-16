class Solution {

    public int maxProfit(int[] prices, int k) {
        int n = prices.length;
        int[][] dp = new int[k + 1][n + 1];
        for (int t = 1; t <= k; ++t) {
            int maxDiff = Integer.MIN_VALUE;
            for (int i = 1; i <= n; ++i) {
                dp[t][i] = Math.max(Math.max(dp[t][i - 1], dp[t - 1][i]), maxDiff + prices[i - 1]);
                maxDiff = Math.max(maxDiff, dp[t - 1][i] - prices[i - 1]);
            }
        }
        return dp[k][n];
    }
};

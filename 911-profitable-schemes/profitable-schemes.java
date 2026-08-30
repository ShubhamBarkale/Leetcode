class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        final int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;

        for (int i = 0; i < group.length; i++) {
            int members = group[i];
            int gain = profit[i];
            for (int m = n; m >= members; m--) {
                for (int p = minProfit; p >= 0; p--) {

                    int newProfit = Math.min(minProfit, p + gain);

                    dp[m][newProfit] =
                        (dp[m][newProfit] + dp[m - members][p])
                        % MOD;
                }
            }
        }

        int answer = 0;

        for (int m = 0; m <= n; m++) {
            answer = (answer + dp[m][minProfit]) % MOD;
        }

        return answer;
    }
}
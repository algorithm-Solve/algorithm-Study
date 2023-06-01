class 프로그래머스_거스름돈 {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];

        for (int k : money) {
            dp[k]++;
            for (int j = k; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - k]) % 1000000007;
            }
        }
        return dp[n];
    }
}
/*
*   기본적인 냅색 DP 문제
*   1원부터 N원까지 모든 경우의 수를 코인을 순회하며 기록한다.
*/

class 거스름돈 {
    static final int MOD = 1_000_000_007;

    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];

        for (int m : money) {
            dp[m]++;
            for (int i = m + 1; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - m]) % MOD;
            }
        }

        return dp[n];
    }
}

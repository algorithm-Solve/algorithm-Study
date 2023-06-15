class 프로그래머스_연속펄스 {
    public long solution(int[] sequence) {

        long[][] dp = new long[2][sequence.length];
        long max = 0;
        int[] sw = new int[]{ -1, 1 };

        dp[0][0] = sequence[0];
        dp[1][0] = sequence[0] * -1;

        max = Math.max(dp[0][0], dp[1][0]);

        for(int i = 0; i < 2; i++) {
            for(int j = 1; j < sequence.length; j++) {
                dp[i][j] = sequence[j] * sw[i] + (dp[i][j - 1] < 0 ? 0 : dp[i][j - 1]);
                sw[i] *= -1;

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
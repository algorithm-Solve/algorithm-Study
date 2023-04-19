class 프로그래머스_등굣길 {
    public int solution(int m, int n, int[][] puddles) {

        int[][] dp = new int[n + 1][m + 1];
        int l = puddles.length;

        for (int i = 0; i < l; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }

        for (int i = 2; i <= m; i++) {
            if (dp[1][i] == -1) break;
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            if (dp[i][1] == -1) break;
            dp[i][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (dp[i][j] == -1) continue;
                if (dp[i - 1][j] != -1) dp[i][j] += dp[i - 1][j];
                if (dp[i][j - 1] != -1) dp[i][j] += dp[i][j - 1];
                dp[i][j] = dp[i][j] % 1000000007;
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4;
        int m = 3;
        int[][] puddles = {{2, 2}};
        System.out.println(sol.solution(n, m, puddles));
    }
}
package com.example.suchan;

public class 땅따먹기 {

    int solution(int[][] land) {

        int answer = Integer.MIN_VALUE;
        int n = land.length;

        int[][] dp = new int[n][land[0].length];

        System.arraycopy(land[0], 0, dp[0], 0, land[0].length);

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < land[i].length; j++) {

                int max = Integer.MIN_VALUE;
                for (int k = 0; k < 4; k++) {

                    if (j == k) {
                        continue;
                    }

                    max = Math.max(max, dp[i - 1][k]);
                }

                dp[i][j] = land[i][j] + max;
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }

        return answer;
    }

}

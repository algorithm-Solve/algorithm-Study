package 연습문제;

import java.util.Arrays;

/**
 * dp 방식을 채택
 * 각 행의 값은 이전 행의 값들 중 중복된 행의 숫자를 제외한 가장 큰 값
 */
public class 땅따먹기 {
	int solution(int[][] land) {
		int row = land.length;
		int col = land[0].length;

		int[][] dp = new int[row][col];

		for (int i = 0; i < col; i++) {
			dp[0][i] = land[0][i];
		}

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int max = Integer.MIN_VALUE;
				for (int k = 0; k < 4; k++) {
					if (k == j) {
						continue;
					}
					// 이전 행의 값 중 가장 큰 값
					max = Math.max(max, dp[i - 1][k]);
				}
				dp[i][j] = land[i][j] + max;
			}
		}
		return Arrays.stream(dp[row - 1]).max().orElse(0);
	}
}

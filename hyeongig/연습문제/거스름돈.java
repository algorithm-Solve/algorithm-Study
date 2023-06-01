package 연습문제;

/*
DP(다이나믹 프로그래밍) 이용
dp[i]는 주어진 동전으로 만들 수 있는 경우의 수
- 현재 동전 가치를 기준으로 그 동전보다 가치를 만드는 경우를 모두 업데이트
* */
public class 거스름돈 {
	public int solution(int n, int[] money) {
		int[] dp = new int[n + 1];
		dp[0] = 1; // 0원을 만들 수 있는 경우의 수
		for (int now : money) {
			for (int i = now; i <= n; i++) {
				dp[i] = (dp[i] + dp[i - now]) % 1_000_000_007;
			}
		}
		return dp[n];
	}
}

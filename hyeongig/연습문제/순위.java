package 연습문제;

/* 플로이드 워셜 이용
현재 노드를 거쳐 가는 노드를 기준을 이용

2차원 배열에서 이겼거나 진 경기의 수가 n - 1일 경우 정답 수 증가
*/

public class 순위 {
	public int solution(int n, int[][] results) {
		int answer = 0;
		int[][] winLose = initFloydWarshall(n, results);

		for (int i = 1; i <= n; i++) {
			int count = 0;
			for (int j = 1; j <= n; j++) {
				if (winLose[i][j] == 1 || winLose[j][i] == 1) { // 이겼거나 진 경우
					count++;
				}
			}
			if (count == n - 1) { // 다른 인원들과 모두 경기를 한 경우
				answer++;
			}
		}
		return answer;
	}

	public int[][] initFloydWarshall(int n, int[][] results) {
		int[][] dist = new int[n + 1][n + 1];

		for (int[] result : results) {
			dist[result[0]][result[1]] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dist[i][k] == 1 && dist[k][j] == 1) {
						dist[i][j] = 1;
					}
				}
			}
		}
		return dist;
	}
}

package 연습문제;

/*
DP 방식 -> maze[i][j] = maze[i - 1][j] + maze[i][j - 1] 애서 착안
 */
public class 등굣길 {
	public int solution(int m, int n, int[][] puddles) {
		final int REMAINDER = 1000000007;
		int[][] maze = new int[n + 1][m + 1];
		for (int[] puddle : puddles) {
			maze[puddle[1]][puddle[0]] = -1;
		}
		maze[1][1] = 1;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (maze[i][j] == -1) {
					continue;
				}
				if (maze[i - 1][j] > 0) {
					maze[i][j] += maze[i - 1][j] % REMAINDER;
				}
				if (maze[i][j - 1] > 0) {
					maze[i][j] += maze[i][j - 1] % REMAINDER;
				}
			}
		}
		return maze[n][m] % REMAINDER;
	}
}

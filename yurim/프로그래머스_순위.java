import java.util.Arrays;

class 프로그래머스_순위 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], 1000000000);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) graph[i][j] = 0;
            }
        }

        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            boolean check = false;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (graph[i][j] == 1000000000 && graph[j][i] == 1000000000) {
                    check = true;
                    break;
                }
            }
            if (check == false) answer++;
        }
        return answer;
    }
}
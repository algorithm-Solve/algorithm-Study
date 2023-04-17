/*
*   각 칸을 시작점부터 순서대로 순회하면서 
*   올 수 있는 경우의 수인 좌측칸과 윗칸의 경우의 수를 더해 저장하는 방식으로, 도착점까지 구한다.
*   t.c = O(nm)
*/


class Solution {
    static final int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m + 1][n + 1];
        map[1][1] = 1;
        for (int[] puddle : puddles) {
            map[puddle[0]][puddle[1]] = -1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                map[i][j] += Math.max(0, map[i - 1][j]);
                map[i][j] += Math.max(0, map[i][j - 1]);
                map[i][j] %= MOD;
            }
        }

        return map[m][n];
    }
}

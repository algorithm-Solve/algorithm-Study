import java.util.*;

/*
*   위상정렬을 이용해여 풀었습니다.
*   순위가 확정됐다 : 나보다 항상 높은순위인 인원 + 나보다 항상 낮은 순위인 인원 + 나(1) = N(전체인원)
*   앞 순위부터 정해보면, 위상정렬 방식을 이용해서 앞선순위가 없는 플레이어부터 큐에 넣고 그 플레이어를 방문하면, 그 플레이어 뒤에 있는 플레이어들에게서 현재 노드를 지워준다.
*   노드를 지웠을 때 앞 선 순위가 없는 플레이어가 되면 큐에 삽입하는 방식으로 최소한 앞에 몇 명이 있는지 확정짓는다.
*   같은 방식으로 뒷순위도 결정
*   앞순위 + 뒷순위 + 1 이 N이라면 순위가 확정된 플레이어로 반환
*/

class Solution {
    static class Player {
        Set<Integer> front = new HashSet<>();
        Set<Integer> back = new HashSet<>();
        int frontCount;
        int backCount;
    }

    public int solution(int n, int[][] results) {
        Player[] players = new Player[n + 1];
        for (int i = 1; i <= n; i++) {
            players[i] = new Player();
        }

        for (int[] result : results) {
            players[result[0]].back.add(result[1]);
            players[result[1]].front.add(result[0]);
        }

        setFrontScore(n, players); // 앞에 몇 명 있는지 확정짓기
        setBackScore(n, players); // 뒤에 몇 명 있는지 확정짓기

        return getConfirmPlayers(n, players); // 확정된 인원 숫자
    }


    // 앞과 뒤에 숫자 합이 전체인원-1 이라면 순위는 확정
    private int getConfirmPlayers(int n, Player[] players) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (players[i].front.size() + players[i].back.size() == n - 1) {
                count++;
            }
        }
        return count;
    }

    private void setBackScore(int n, Player[] players) {
        Queue<Player> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            players[i].backCount = players[i].back.size();
            if (players[i].back.size() == 0) {
                queue.add(players[i]);
            }
        }

        while (!queue.isEmpty()) { // 뒷 순위 결정
            Player player = queue.poll();

            for (Integer no : player.front) {
                players[no].back.addAll(player.back);
                if (--players[no].backCount == 0) {
                    queue.add(players[no]);
                }
            }
        }
    }

    private void setFrontScore(int n, Player[] players) {
        Queue<Player> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            players[i].frontCount = players[i].front.size();
            if (players[i].front.size() == 0) {
                queue.add(players[i]);
            }
        }

        while (!queue.isEmpty()) { // 앞 순위 결정
            Player player = queue.poll();
            for (Integer no : player.back) {
                players[no].front.addAll(player.front);
                if (--players[no].frontCount == 0) {
                    queue.add(players[no]);
                }
            }
        }
    }
}

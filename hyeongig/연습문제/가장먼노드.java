package 연습문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 그래프를 담을 ArrayList 배열 lists
 * 노드에서 떨어진 거리 길이를 담을 배열 visited
 *
 * Queue 를 이용하여 BFS를 통해 인접 노드 방문시 visited[인접노드] +1
 * visited 배열의 max 값과 그 해당하는 값의 개수를 출력
 */
class Solution_가장먼노드 {

	static ArrayList<Integer>[] lists;
	static int[] visited;

	public int solution(int n, int[][] edge) {

		lists = new ArrayList[n + 1];
		visited = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			lists[i] = new ArrayList<>();
		}
		for (int i = 0; i < edge.length; i++) {
			lists[edge[i][0]].add(edge[i][1]);
			lists[edge[i][1]].add(edge[i][0]);
		}
		Arrays.fill(visited, -1);
		BFS();
		int maxNum = Arrays.stream(visited).max().orElse(0);
		return (int)Arrays.stream(visited).filter(i -> i == maxNum).count();
	}

	private void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1]++;
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			for (int adjacentNode : lists[nowNode]) {
				if (visited[adjacentNode] == -1) {
					visited[adjacentNode] = visited[nowNode] + 1;
					queue.add(adjacentNode);
				}
			}
		}
	}
}

public class 가장먼노드 {
	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(new Solution_가장먼노드().solution(n, vertex));
	}
}

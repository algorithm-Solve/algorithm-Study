package 연습문제;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1. 귤의 종류별 개수를 저장하기 위해 HashMap 사용
 * 2. 이를 저장하기 위해 Harvest 클래스를 만듬
 * 3. count별 내림차순 정리를 위해 PriorityQueue 사용
 * 4. 귤의 개수가 k보다 커질때까지 answer++ 해주며 정답 도출
 *
 * -> 정렬 방법을 생각해서 PriorityQueue를 도입했지만 모범답안의 List를 이용한 풀이가 더 빠름....
 */
public class 귤고르기 {
	public int solution(int k, int[] tangerine) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : tangerine) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Harvest> pq = new PriorityQueue<>(
			(o1, o2) -> o2.count > o1.count ? 1 : -1
		);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.offer(new Harvest(entry.getKey(), entry.getValue()));
		}

		int tanCount = 0;
		int answer = 0;

		while (k > tanCount) {
			if (pq.isEmpty()) {
				break;
			}
			tanCount += pq.poll().count;
			answer++;
		}
		return answer;
	}

	static class Harvest {
		int number;
		int count;

		public Harvest(int number, int count) {
			this.number = number;
			this.count = count;
		}
	}
}

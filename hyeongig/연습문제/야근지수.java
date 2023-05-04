package 연습문제;

import java.util.Collections;
import java.util.PriorityQueue;

/*
각 요소 중 최댓값의 크기가 적어질때 야근지수가 최소
-> PriorityQueue 역순을 이용
최댓값의 크기가 0인 경우 남은 작업량이 없음므로 반복문 탈출
 */
public class 야근지수 {
	public long solution(int n, int[] works) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int time : works) {
			pq.offer(time);
		}
		while (n > 0 && !pq.isEmpty()) {
			int nowMax = pq.poll();
			nowMax--;
			if (nowMax < 0) {
				break;
			}
			pq.offer(nowMax);
			n--;
		}
		long answer = 0;
		while (!pq.isEmpty()) {
			answer += Math.pow(pq.poll(), 2);
		}
		return answer;
	}
}

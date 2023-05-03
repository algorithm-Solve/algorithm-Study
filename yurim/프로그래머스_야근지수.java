// 야근 피로도 = 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한값
// 최소의 야근 피로도를 구하는 문제.
// 우선순위 큐

import java.util.Collections;
import java.util.PriorityQueue;

class 프로그래머스_야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐 선언 + 내림차순 정렬

        for (int j : works) {
            pq.offer(j);
        }

        while (n > 0) {
            int work = pq.poll();
            if (work == 0) break;
            work -= 1;
            pq.offer(work);
            n -= 1;
        }

        for (int work : pq) {
            answer += (long) work * work;
        }
        return answer;
    }
}
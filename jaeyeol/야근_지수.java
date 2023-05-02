import java.util.*;

/*
*   같은 잔업량을 묶어서 개수로 카운팅한다.
*   작업량 기준 우선순위 큐에 넣고 우선적으로 처리하고 n이 다 쓰이면, 남은 작업량을 계산한다.
*/

class Work {
    int amount;
    int count;

    Work(int amount,int count){
        this.amount = amount;
        this.count = count;
    }
}

class 야근_지수 {

    public long solution(int n, int[] works) {
        PriorityQueue<Work> pq = getWorks(works);

        while (!pq.isEmpty() && n > 0) {
            Work work = pq.poll();

            if (!pq.isEmpty()) {
                Work next = pq.peek();
                int diff = work.amount - next.amount;
                if (diff * work.count <= n) { // 합치기
                    pq.poll();
                    pq.add(new Work(next.amount, next.count + work.count));
                    n -= diff * work.count;
                    continue;
                }
            } else if (work.count * work.amount <= n) { // 다 끝내면
                return 0;
            }

            work.amount -= n / work.count;
            int rest = n % work.count;
            if (rest > 0) {
                pq.add(new Work(work.amount - 1, rest));
                pq.add(new Work(work.amount, work.count - rest));
            } else {
                pq.add(work);
            }
            break;
        }
        
        return pq.stream()
                .map(work -> (long) Math.pow(work.amount, 2) * work.count)
                .mapToLong(i -> i)
                .sum();
    }

    private PriorityQueue<Work> getWorks(int[] works) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int work : works) {
            map.put(work, map.getOrDefault(work, 0) + 1);
        }

        PriorityQueue<Work> pq = new PriorityQueue<>((w1, w2) -> w2.amount - w1.amount);
        for (int key : map.keySet()) {
            pq.add(new Work(key, map.get(key)));
        }
        return pq;
    }
}

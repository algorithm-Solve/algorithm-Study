import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class 프로그래머스_귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int index = 0;

        Map<Integer, Integer> map = new HashMap<>(); // map을 이용하여 귤의 크기와 그에 따른 갯수를 key와 value에 저장

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1); // map.getOrDefault를 사용
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(((o1, o2) -> map.get(o2) - map.get(o1))); // list 내림차순 정렬(value기준)

        while (k > 0) {
            k -= map.get(list.get(index));
            answer++;
            index++;
        }
        return answer;
    }
}
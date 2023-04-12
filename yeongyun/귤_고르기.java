import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int cnt = 0;
        
        // 귤의 크기를 key로 해당 크기 별 개수를 value로 저장하기 위해 Map선언
        Map<Integer, Integer> map = new HashMap<>();    // 
        for (int i:tangerine) {
            map.put(i, map.getOrDefault(i,0)+1); // 메서드 getOrDefault를 사용하여 지정된 키를 찾으면 defaultValue(여기선 0)를 반환 후 1씩 더해준다
        }
        
        // collection함수 사용을 위해 Map을 List형태로 변환
        // value 값이 필요하기 때문에 entrySet을 이용
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        // 람다 함수를 사용하여 value기준으로 내림차순 정렬(개수가 많은 귤부터 담기 위해)
        entryList.sort(((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey())));
        
        for(Map.Entry<Integer, Integer> entry : entryList){
            cnt += entry.getValue();    // 개수가 많은 귤 부터 상자에 담음
            answer += 1;    // 귤 종류 하나 추가
            if(cnt >= k) break;   // 담긴 귤 개수(cnt)가 담으려는 귤 개수(k)보다 크거나 같아질 때 종료
        }
        return answer;
    }
}

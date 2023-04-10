import java.util.*;
import java.util.stream.Collectors;

/*
*   귤의 크기별로 Map을 이용해서 카운팅한다.
*   개수가 많은 순으로 선택하고 k개가 선택됐다면 종류 개수를 리턴한다.
*/


class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        return getTypeCount(k, getMapValueList(tangerine));
    }

    private List<Integer> getMapValueList(int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        return map.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private int getTypeCount(int k, List<Integer> values) {
        int typeCount = 0;

        for (Integer value : values) {
            k -= value;
            typeCount++;
            if (k <= 0) {
                break;
            }
        }
        
        return typeCount;
    }

}

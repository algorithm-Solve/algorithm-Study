package KAKAO_BLIND_RECRUITMENT_2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int nowDays = getDays(today);
        Map<String, Integer> map = termsToMap(terms);

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int plusMonth = map.get(privacy[1]) * 28;
            int expireDays = getDays(privacy[0]) + plusMonth - 1;
            if (expireDays < nowDays) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getDays(String today) {
        String[] splitToday = today.split("\\.");
        int year = Integer.parseInt(splitToday[0]);
        int month = Integer.parseInt(splitToday[1]);
        int day = Integer.parseInt(splitToday[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }

    private Map<String, Integer> termsToMap(String[] terms) {
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            map.put(split[0], Integer.parseInt(split[1]));
        }
        return map;
    }
}

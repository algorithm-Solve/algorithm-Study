// 구명보트는 한 번에 최대 2명만 가능

import java.util.Arrays;

class 프로그래머스_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int tmp = 0;

        Arrays.sort(people);

        for (int i = people.length - 1; i >= tmp; i--) {
            if (people[i] + people[tmp] > limit) {
                answer++;
            } else {
                answer++; // 둘이 태울수 있으므로 answer1증가
                tmp++;
            }
        }
        return answer;
    }
}
import java.util.*;

/*
*   사람 무게 순으로 정렬 후 right는 무게가 큰 사람 순 left는 작은 순으로 순회하면서 두 사람의 몸무게를 더해서 
*   구명보트에 태울 수 있으면 둘 다 태우고 아니라면 무게가 큰 사람만 태우는 식으로 모두 태운다.
*/

class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);

        while (left < right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            answer++;
        }
        
        return answer + (left == right ? 1 : 0);
    }
}

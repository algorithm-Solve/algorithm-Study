import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);    // people을 가벼운 사람순으로 정렬
        int min = 0;    // 가장 가벼운 사람의 인덱스를 min으로 정의
        
        for(int max = people.length-1; max >= min; max--) {   // 배열의 마지막 인덱스를 max로 정의하고 그 다음 무거운 순서로 갈 수 있도록 인덱스를 (-)해줌
            if(people[min] + people[max] <= limit) {    // 가벼운 사람과 무거운 사람의 무게 합산이 제한을 넘지 않을때 
                min++;  // 그 다음 가벼운 무게로 갈 수 있도록 min에 1을 더해준다
            }
            answer++;   // if문을 처리 하였다면 min+max가 한 보트에 함께 탄것으로 처리
                        // if문에 걸리지 않았을 경우 max 혼자 보트를 탄 것으로 처리
        }
        
        return answer;
    }
}

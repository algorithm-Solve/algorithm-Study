package 연습문제;

/*
최대 2명
people 정렬 후 가장 무거운 사람과 가장 가벼운 사람을 기준으로 인덱스 설정
1. 두 사람의 무게가 limit를 초과하였을 때 무거운 사람 혼자 타게 함
2. 두사람의 무게가 limit 안 쪽일때 같이 1팀으로 탐
 */

import java.util.Arrays;

public class 구명보트 {
	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int i = 0;
		int j = people.length - 1;

		while (i <= j) {
			if (people[i] + people[j] <= limit) {
				answer++;
				i++;
				j--;
			} else {
				answer++;
				j--;
			}
		}
		return answer;
	}
}

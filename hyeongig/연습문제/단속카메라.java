package 연습문제;

import java.util.*;

/*
그리디 문제
진출 시간을 기준으로 정렬한다.
다음 진입 시간이 이전 진출 시간보다 큰 경우 겹치지 않으므로 카메라수 증가
 */
public class 단속카메라 {
	public int solution(int[][] routes) {
		int answer = 0;
		Arrays.sort(routes , Comparator.comparingInt(o -> o[1]));
		int min = -30000;

		for (int[] route : routes) {
			if (min < route[0]) {
				answer++;
				min = route[1];
			}
		}
		return answer;
	}
}

package 연습문제;

/*
	개수가 홀수 일때는 해당 값에 1을 뺀다.
	food[i]의 절반 만큼 반복하여 StringBuilder 에 입력한다.
	"0" 과 reverse()를 이용하여 반전 한 값을 더해한다.
 */

public class 푸드_파이트_대회 {
	public String solution(int[] food) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < food.length; i++) {
			if (food[i] % 2 != 0) {
				food[i] -= 1;
			}
			sb.append(String.valueOf(i).repeat(Math.max(0, food[i] / 2)));
		}
		String answer = sb.toString();
		String answer2 = sb.reverse().toString();
		return answer + "0" + answer2;
	}
}

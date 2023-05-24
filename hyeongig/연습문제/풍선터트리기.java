package 연습문제;

// 현재 인덱스 기준 왼쪽 최소, 오른쪽 최소 보다 작은 경우 살아남을 수 없다.
// 양쪽 끝 값은 무조건 살아남을 수 있다.

public class 풍선터트리기 {
	public int solution(int[] a) {

		if (a.length == 1) {
			return 1;
		}

		int answer = 2;
		int leftMin = Integer.MAX_VALUE;
		int rightMin = Integer.MAX_VALUE;
		int[] left = new int[a.length];
		int[] right = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			leftMin = Math.min(leftMin, a[i]);
			left[i] = leftMin;
		}

		for (int i = a.length - 1; i >= 0; i--) {
			rightMin = Math.min(rightMin, a[i]);
			right[i] = rightMin;
		}

		for (int i = 1; i < a.length - 1; i++) {
			if (left[i] < a[i] && right[i] < a[i]) {
				continue;
			}
			answer++;
		}

		return answer;
	}
}

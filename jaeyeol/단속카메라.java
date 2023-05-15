import java.util.*;

/*
*   경로 진입점이 낮은 경로부터 순회하면서 다음 경로 시작점이 이전까지 경로 끝점의 최솟값보다 큰 경우 카메라를 설치한다.
*   없을 경우 마지막 지점에 카메라를 설치한다.
*/

class 단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a1, a2) -> a1[0] - a2[0]);
        int answer = 0;
        int end = 30001;

        for (int[] route : routes) {
            if (end < route[0]) {
                answer++;
                end = route[1];
            } else {
                end = Math.min(end, route[1]);
            }
        }

        return answer + 1;
    }
}

// 지켜야 하는 조건 1) 4칸 中 한 칸만 밟을 수 있음 2) 같은 열을 연속해서 밟을 수 없음
// 구해야 하는 값 : 얻을 수 있는 점수의 최댓값
// 풀이 : i + 1값은 i값에서 선택할 수 있는 최댓값을 기존 i + 1에 더했을 때 가장 큰 값
// (예를 들어, land[1][0]가 5라는 값을 가지고 있을 때, 같은 열을 제외하고 Math.max()를 이용하여 구한 최댓값을 더해준다.
// 이런식으로 반복문을 진행했을 때 그럼 land[1][0], land[1][1], land[1][2], land[1][3]이 재설정되고
// land[2][0] = Math.max(Math.max(land[1][1], land[1][2], ....이런식으로 해당 값이 더해지게 된다.
// 결과적으로 계산된 land배열의 가장 마지막 값들중의 최댓값(앞의 최댓값을 더하고 더한 누적값이 되기때문)을 return 해야하기때문에
// answer배열을 만들어 마지막 값들을 저장하고, answer배열을 정렬하여 작은 숫자 → 높은 숫자 순으로 정렬 한 뒤
// answer.length - 1의 값(가장 큰 값)을 return하면 완료

import java.util.Arrays;

class 프로그래머스_땅따먹기 {
    int solution(int[][] land) {

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]);
            land[i][1] += Math.max(Math.max(land[i - 1][0], land[i - 1][2]), land[i - 1][3]);
            land[i][2] += Math.max(Math.max(land[i - 1][1], land[i - 1][0]), land[i - 1][3]);
            land[i][3] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][0]);
        }

        int[] answer = land[land.length - 1]; // 마지막 값들을 answer배열에 저장
        Arrays.sort(answer); // 정렬
        return answer[answer.length - 1]; // 가장 마지막 값이 최댓값이 되므로, 해당 값을 return
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(sol.solution(land));
    }
}
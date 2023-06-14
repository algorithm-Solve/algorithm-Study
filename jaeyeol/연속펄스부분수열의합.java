/*
*   연속 부분 수열의 최대값은 누적합이 0이하로 되면 끊고 0이상이면 쭉 누적합을 진행해주면서 dp로 풀이.
*   각 펄스의 경우의 수 2개를 각각 구해서 최대값을 반환한다.
*/

class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        long pulse1 = 0;
        long pulse1Max = 0;
        long pulse2 = 0;
        long pulse2Max = 0;

        for (int i = 0; i < sequence.length; i++) {
            pulse1 = Math.max(0, pulse1 + (i % 2 == 0 ? sequence[i] : -sequence[i]));
            pulse2 = Math.max(0, pulse2 + (i % 2 == 0 ? -sequence[i] : sequence[i]));
            pulse1Max = Math.max(pulse1, pulse1Max);
            pulse2Max = Math.max(pulse2, pulse2Max);
        }

        return Math.max(pulse1Max, pulse2Max);
    }

}

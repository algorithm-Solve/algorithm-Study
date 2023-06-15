package 연습문제;

public class 연속펄스부분수열의합 {

	private void makePulse(int[] plusPulse, int[] minusPulse, int[] sequence) {
		int n = 1;
		for (int i = 0; i < sequence.length; i++) {
			plusPulse[i] = sequence[i] * n;
			n *= -1;
			minusPulse[i] = sequence[i] * n;
		}
	}

	private static long getMaxValue(int[] sequence, int[] plusPulse, int[] minusPulse, long[] dpPlus, long[] dpMinus) {
		long answer;
		dpPlus[0] = plusPulse[0];
		dpMinus[0] = minusPulse[0];
		answer = Math.max(dpPlus[0], dpMinus[0]);

		for (int i = 1; i < sequence.length; i++) {
			dpPlus[i] = Math.max(dpPlus[i - 1] + plusPulse[i], plusPulse[i]);
			dpMinus[i] = Math.max(dpMinus[i - 1] + minusPulse[i], minusPulse[i]);
			answer = Math.max(answer, Math.max(dpPlus[i], dpMinus[i]));
		}
		return answer;
	}

	public long solution(int[] sequence) {
		int[] plusPulse = new int[sequence.length];
		int[] minusPulse = new int[sequence.length];
		makePulse(plusPulse, minusPulse, sequence);

		long[] dpPlus = new long[sequence.length];
		long[] dpMinus = new long[sequence.length];
		return getMaxValue(sequence, plusPulse, minusPulse, dpPlus, dpMinus);
	}
}

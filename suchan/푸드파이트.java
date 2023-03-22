package com.example.suchan;

public class 푸드파이트 {

    public String solution(int[] food) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int num = food[i] / 2;

            sb.append(String.valueOf(i).repeat(Math.max(0, num)));
        }

        answer = sb.toString() + "0" + sb.reverse().toString();
        return answer;
    }

}

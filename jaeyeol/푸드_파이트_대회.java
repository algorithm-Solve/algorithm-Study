
/*
*   음식 수 / 2 만큼 추가하고 
*   물을 채워 넣은 다음
*   역순으로 채워 넣는다.
*/

public class 푸드_파이트_대회 {
    public String solution(int[] food) {
        StringBuilder result = new StringBuilder();

        for (int num = 1; num < food.length; num++) {
            result.append(String.valueOf(num).repeat(food[num] >> 1));
        }
      
        result.append(0);
      
        for (int i = result.length() - 2; i >= 0; i--) {
            result.append(result.charAt(i));
        }

        return result.toString();
    }
}


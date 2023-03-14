import java.util.*;

/*
*   개인정보 수집 일자에 약관 별 유효기간을 더한 일자가 오늘보다 이후라면 파기해야한다.
*   한 달을 28일로 고정시켜놔서 날짜를 일 단위 수로 표현할 수 있고, 그 수로 만료 날짜를 비교하여 판단하는 방식으로 풀이.
*   
*   todayDays = 오늘의 날짜 수
*   saveTerms() -> 약관을 (index 0 : A) 부터 기록
*   getDayCount(날짜) -> 날짜를 수로 표현
*   isExpired(날짜, 약관 타입) -> 오늘 기준으로 만료 됐는지 여부 반환
* */

public class 개인정보_수집_유효기간 {
    static class expiryCalculator {
        int todayDays;
        int[] term;

        public expiryCalculator(String today) {
            this.todayDays = getDayCount(today);
            this.term = new int['Z' - 'A' + 1];
        }

        public int getDayCount(String date) {
            String[] dateInfo = date.split("\\.");
            return Integer.parseInt(dateInfo[0]) * 12 * 28 + Integer.parseInt(dateInfo[1]) * 28 + Integer.parseInt(dateInfo[2]);
        }

        public boolean isExpired(String startDate, char type) {
            int expireMonth = term[type - 'A'];
            return getDayCount(startDate) + expireMonth * 28 <= todayDays;
        }

        public void saveTerms(String[] terms) {
            for (String t : terms) {
                this.term[t.charAt(0) - 'A'] = Integer.parseInt(t.split(" ")[1]);
            }
        }
    }


    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Solution.expiryCalculator expiryCalculator = new Solution.expiryCalculator(today);
        expiryCalculator.saveTerms(terms);

        for (int i = 0; i < privacies.length; i++) {
            String[] privacySplit = privacies[i].split(" ");
            if (expiryCalculator.isExpired(privacySplit[0], privacySplit[1].charAt(0))) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}

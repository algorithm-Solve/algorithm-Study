// 해결을 못했습니다..!
// 추후에 더 보완하여 업로드 해놓겠습니다!

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String, String> termsMap = new HashMap<>();
        Map<String, String> privaciesMap = new HashMap<>();

        // terms를 약관종류와 기관으로 구분(공백이용)
        for(int i=0; i< terms.length; i++) {
            String[] divTerms = terms[i].split(" ");
            termsMap.put(divTerms[0], divTerms[1]);
        }

        // privacies 마찬가지로 구분
        String[] divPrivacies={};
        String[] divDate={};
        for(int i=0; i< privacies.length; i++) {
            // 공백으로 날짜와 약관 구분
            divPrivacies = privacies[i].split(" ");
            // .으로 날짜 년월일 구분
            divDate = divPrivacies[0].split("\\.");
            privaciesMap.put(divPrivacies[0], divPrivacies[1]);
        }

        int year = Integer.parseInt(divDate[0]);
        int month = Integer.parseInt(divDate[1]);
        int date = Integer.parseInt(divDate[2]);

        // termsMap에서 약관종류에 따른 값 가져온 후 덧셈을 위해 int로 변환
        int A = Integer.parseInt(termsMap.get(divPrivacies[1]));

        int newMonth = month+A;
        int newYear = year;
        //if (newMonth > 12) {return newYear = year+1;}
        int newDate = date-1;
        //if (newDate==0)

        
        int[] answer = {};
        return answer;
    }
}

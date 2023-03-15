import java.util.*;

class 프로그래머스_개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>(); // 답을 담을 answer(순서대로 저장할 예정이기에 list사용)
        Map<String, Integer> map = new HashMap<>(); // term(약관의 유효기간을(약관종류(key), 유효기간(value))을 저장하기 위한 map

        int date = getDate(today);

        for (String s : terms) { //약관 유효기간 저장할 for문
            String[] term = s.split(" "); // 공백기준 자르기
            map.put(term[0], Integer.parseInt(term[1])); // 인덱스 0에 해당하는 값을 key, 인덱스 1에 해당하는 값을 value에 저장
        }

        for (int i = 0; i < privacies.length; i++) { // 개인정보의 갯수만큼 for문을 돌면서
            String[] privacy = privacies[i].split(" "); // 공백을 기준으로 자르기 → "2021.05.02 A"가 "2021.05.02" 와 "A"로 나뉨
            // 개인 정보 입력 날짜와 약관을 더한 만료날짜가 오늘 날짜보다 이전이면 파기해야할 자료이므로 추가
            if (getDate(privacy[0]) + (map.get(privacy[1]) * 28) <= date) // 만약 privacy의 0번째 인덱스(날짜) + privacy의 1번째 인덱스(약관종류(약관종류에 따른 유효기간의 value) * 한달(28)이 date보다 작으면
                answer.add(i + 1); // 파기해야 할 자료라고 판단, answer에 추가
        }

        return answer.stream().mapToInt(i -> i).toArray(); // list를 int배열로 바꾸는 stream사용하여 int배열로 바꿔서 return
    }

    private int getDate(String today) {
        String[] date = today.split("\\."); // 주어진 today를 "."을 기준으로 잘라줌(년,월,일) + "\\"를 붙이는 이유는 split의 인자로 들어가는 String토큰이 regex 정규식이기때문
        int year = Integer.parseInt(date[0]); // split으로 잘랐을 때 0번째 인덱스에 해당하는 값 = 년
        int month = Integer.parseInt(date[1]);// split으로 잘랐을 때 1번째 인덱스에 해당하는 값 = 월
        int day = Integer.parseInt(date[2]);// split으로 잘랐을 때 2번째 인덱스에 해당하는 값 = 일

        return (year * 12 * 28) + (month * 28) + day; // 년 → year * 한달(28) * 12개월(12) + 월 → month * 한달(28) + 일 → day
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        String today2 = "2020.01.01";
        String[] terms2 = {"Z 3", "D 5"};
        String[] privacies2 = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        System.out.println(Arrays.toString(sol.solution(today, terms, privacies)));
        System.out.println(Arrays.toString(sol.solution(today2, terms2, privacies2)));
    }
}
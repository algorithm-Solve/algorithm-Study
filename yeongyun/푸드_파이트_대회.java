class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i=1; i< food.length; i++) {
            int cnt = food[i]/2;            // food배열의 원소를 2명으로 나누어 몫만 챙긴다
            for(int j = 0; j < cnt; j++) {  // 나온 몫(=cnt)만큼 음식을 나열하기 위한 for문
                answer += i;                // answer에 cnt번 i번 문자를 더해준다
            }
        }
        StringBuffer rvs = new StringBuffer(answer);    // reverse를 사용하기 위함
        answer = answer+"0"+rvs.reverse();
        return answer;
    }
}

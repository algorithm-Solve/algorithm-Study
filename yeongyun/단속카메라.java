import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int min = -30001;
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        for (int i = 0; i < routes.length; i++) {
            if (min < routes[i][0]) {
                min = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}

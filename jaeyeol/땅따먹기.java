import java.util.*;

/*
*   이전 행까지의 각 열에서의 올 수 있는 값의 최댓값을 저장해놓고 
*   현재 행의 최댓값을 구할 때 이전 행의 최대값들을 사용해서 구하는 dp 방식으로 풀이. 
*   tc : O(N)
*/

class Solution {
    static final int COL = 4;
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        
        for (int i = 1; i < n; i++){
            for(int j = 0; j < COL; j++) {
                int prevMax = 0;
                
                for (int k = 0; k < COL; k++) {
                    if(j != k) {
                        prevMax = Math.max(prevMax, land[i-1][k]);
                    }
                }
                land[i][j] += prevMax;
            }
        }
        
        return Arrays.stream(land[n-1]).max().getAsInt();
    }
    
}

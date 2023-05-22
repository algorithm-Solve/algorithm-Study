
/*
*   getCount(): 최후의 남을 수 있는 조건은 좌측 수들의 최소값, 우측 수들의 최소값, 현재 수 중에 적어도 1번은 큰 수를 선택할 수 있으므로 가장 큰 수만 아니면 된다.
*   앞 쪽부터 최소값, 뒤쪽부터 최소값을 미리 구해놔서 연산에 사용한다.
*/


class 풍선터트리기 {
    public int solution(int[] a) {
        int n = a.length;
        
        int[] front = new int[n];
        front[0] = a[0];
        for (int i = 1; i < n; i++) {
            front[i] = Math.min(a[i], front[i - 1]);
        }

        int[] back = new int[n];
        back[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            back[i] = Math.min(a[i], back[i + 1]);
        }

        return getCount(a, n, front, back);
    }

    private int getCount(int[] a, int n, int[] front, int[] back) {
        int count = Math.min(2, n);
        
        for (int i = 1; i < n - 1; i++) {
            int max = Math.max(a[i], Math.max(front[i - 1], back[i + 1]));
            if (max != a[i]) {
                count++;
            }
        }
        return count;
    }
}

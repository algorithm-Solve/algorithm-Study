class 프로그래머스_풍선터트리기 {
    public int solution(int[] a) {
        int cnt = 2;
        int lef = a[0];
        int rig = a[a.length - 1];

        int x = 1;
        int y = a.length - 2;

        for (int i = 1; i < a.length - 1; i++) {
            if (lef > rig) {
                if (lef > a[x]) {
                    cnt++;
                    lef = a[x];
                }
                x++;
            } else {
                if (rig > a[y]) {
                    cnt++;
                    rig = a[y];
                }
                y--;
            }
        }
        return cnt;
    }
}
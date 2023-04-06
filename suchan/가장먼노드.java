package com.example.suchan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class 가장먼노드 {

    static Queue<Integer> queue = new LinkedList<>();
    static int arr[];
    static ArrayList<Integer>[] list;
    static boolean visited[];

    public static int solution(int n, int[][] edge) {
        int ans = 0;
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] ints : edge) {
            int a = ints[0];
            int b = ints[1];
            list[a].add(b);
            list[b].add(a);
        }

        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int a = queue.poll();
            for (int b : list[a]) {
                if (visited[b]) {
                    continue;
                }
                queue.add(b);
                visited[b] = true;
                arr[b] = arr[a] + 1;
            }
        }

        Arrays.sort(arr);
        int cnt = 0;
        int max = arr[n];
        for (int i = n; i >= 1; i--) {
            if (max == arr[i]) {
                cnt++;
            } else {
                break;
            }
        }

        return cnt;
    }
}

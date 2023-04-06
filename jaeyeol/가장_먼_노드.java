import java.util.*;

/*
*   BFS로 1번 노드부터 순회하면서 매 Depth마다 저장된 노드의 개수를 저장해놓고
*   탐색이 끝나면 현재 저장되어 있는 노드 개수를 리턴한다.
*   t.c = O(N)
*/

class Solution {
    public int solution(int n, int[][] edge) {
        return getMaxDistanceNodes(getNodes(n, edge));
    }

    static class Node {
        int root;
        Node link;

        public Node(int root, Node link) {
            this.root = root;
            this.link = link;
        }
    }

    private Node[] getNodes(int n, int[][] edge) {
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i, null);
        }

        for (int[] e : edge) {
            nodes[e[0]].link = new Node(e[1], nodes[e[0]].link);
            nodes[e[1]].link = new Node(e[0], nodes[e[1]].link);
        }

        return nodes;
    }

    public int getMaxDistanceNodes(Node[] nodes) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nodes.length];

        queue.add(1);
        visited[1] = true;

        int nodeCount = 0;

        while (!queue.isEmpty()) {
            Queue<Integer> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (Node node = nodes[cur].link; node != null; node = node.link) {
                    if (!visited[node.root]) {
                        visited[node.root] = true;
                        next.add(node.root);
                    }
                }
            }

            if (next.size() > 0) {
                nodeCount = next.size();
            }
            queue = next;
        }

        return nodeCount;
    }

}

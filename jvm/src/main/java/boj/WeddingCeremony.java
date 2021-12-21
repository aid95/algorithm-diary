package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WeddingCeremony {

    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int answer = 0;

        Queue<Node> q = new LinkedList<>();
        visited[1] = true;
        q.offer(new Node(1, 0));
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n.isEnd()) {
                for (int next : graph[n.getNo()]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(new Node(next, n.getDepth() + 1));
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    private static class Node {
        private int no;
        private int depth;

        public Node(int no, int depth) {
            this.no = no;
            this.depth = depth;
        }

        public int getNo() {
            return no;
        }

        public int getDepth() {
            return depth;
        }

        public boolean isEnd() {
            return depth < 2;
        }
    }
}

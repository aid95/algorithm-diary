package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.stream.Collectors;

public class Prerequisite {

    private static final List<Vector<Integer>> graph = new ArrayList<>();
    private static int[] indegree = null;
    private static int[] schedule = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        indegree = new int[l + 1];
        schedule = new int[l];
        for (int i = 0; i <= l; i++) {
            graph.add(new Vector<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            indegree[to]++;
        }

        Queue<Lecture> q = new ArrayDeque<>();
        for (int i = 1; i <= l; i++) {
            if (indegree[i] == 0) {
                q.add(new Lecture(i, 0));
            }
        }
        while (!q.isEmpty()) {
            Lecture cur = q.poll();
            for (int next : graph.get(cur.getNo())) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    schedule[next - 1] = cur.getSemester() + 1;
                    q.add(new Lecture(next, cur.getSemester() + 1));
                }
            }
        }

        String answer = Arrays.stream(schedule).map(i -> i + 1).mapToObj(Integer::toString)
            .collect(Collectors.joining(" "));
        System.out.print(answer);
    }

    private static final class Lecture {

        private final int no;
        private final int semester;

        public Lecture(int no, int semester) {
            this.no = no;
            this.semester = semester;
        }

        public int getNo() {
            return no;
        }

        public int getSemester() {
            return semester;
        }
    }
}

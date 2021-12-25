package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Newcomer {

    private static Rank lastPassedRank = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < testcase; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            PriorityQueue<Rank> pq = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                int[] xy = Arrays.stream(br.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
                pq.offer(new Rank(xy[0], xy[1]));
            }

            lastPassedRank = pq.poll();
            int answer = 1;
            while (!pq.isEmpty()) {
                Rank current = pq.poll();
                if (isPass(current)) {
                    lastPassedRank = current;
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    private static boolean isPass(Rank o) {
        return o.getScore1() < lastPassedRank.getScore1()
            || o.getScore2() < lastPassedRank.getScore2();

    }

    private static class Rank implements Comparable<Rank> {

        private int score1;
        private int score2;

        public Rank(int score1, int score2) {
            this.score1 = score1;
            this.score2 = score2;
        }

        public int compareTo(Rank o) {
            return this.score1 - o.score1;
        }

        public int getScore1() {
            return score1;
        }

        public int getScore2() {
            return score2;
        }
    }
}

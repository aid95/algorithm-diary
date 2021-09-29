package test.coding.algorithm.boj;

import test.coding.algorithm.Solution;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class OlympicGame implements Solution {

  @Override
  public void solve() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    try {
      int N = Integer.parseInt(br.readLine());
      for (int i = 1; i <= N; i++) {
        int M = Integer.parseInt(br.readLine());
        PriorityQueue<Game> games = new PriorityQueue<>();
        for (int j = 0; j < M; j++) {
          StringTokenizer st = new StringTokenizer(br.readLine());
          int D = Integer.parseInt(st.nextToken());
          int S = Integer.parseInt(st.nextToken());
          int E = Integer.parseInt(st.nextToken());
          games.offer(new Game(D, S, E));
        }

        int answer = 1;
        Game currentGame = games.poll();
        while (!games.isEmpty()) {
          Game maybeNextGame = games.poll();
          int day = currentGame != null ? currentGame.day : 0;
          int endDateTime = currentGame != null ? currentGame.endDateTime : 0;
          if (day != maybeNextGame.day || endDateTime <= maybeNextGame.startDateTime) {
            currentGame = maybeNextGame;
            answer = answer + 1;
          }
        }
        sb.append("Scenario #").append(i).append(":").append("\n").append(answer).append("\n\n");
      }

      bw.write(sb.toString());
      bw.flush();
      bw.close();
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static class Game implements Comparable<Game> {

    public final int day;
    public final int startDateTime;
    public final int endDateTime;

    public Game(int day, int startDateTime, int endDateTime) {
      this.day = day;
      this.startDateTime = startDateTime;
      this.endDateTime = endDateTime;
    }

    @Override
    public int compareTo(Game o) {
      if (this.day == o.day) {
        return this.endDateTime - o.endDateTime;
      } else {
        return this.day - o.day;
      }
    }
  }
}

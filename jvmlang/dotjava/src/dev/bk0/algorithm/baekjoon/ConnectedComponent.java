package dev.bk0.algorithm.baekjoon;

import dev.bk0.algorithm.Solution;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ConnectedComponent implements Solution {

  @Override
  public void run() {
    var br = new BufferedReader(new InputStreamReader(System.in));
    var bw = new BufferedWriter(new OutputStreamWriter(System.out));

    try {
      var st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      LinkedList<Integer>[] graph = new LinkedList[N + 1];
      for (int i = 0; i <= N; i++) {
        graph[i] = new LinkedList<>();
      }

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        graph[s].add(e);
        graph[e].add(s);
      }

      int answer = bfs(graph);
      bw.write(String.valueOf(answer));

      bw.flush();
      bw.close();
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static int bfs(LinkedList<Integer>[] graph) {
    int E = graph.length;
    int count = 0;
    boolean visited[] = new boolean[E];
    for (int i = 1; i < E; i++) {
      if (!visited[i]) {
        visited[i] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        while (!queue.isEmpty()) {
          int cur = queue.poll();
          for (var nn : graph[cur]) {
            if (visited[nn]) {
              continue;
            }
            visited[nn] = true;
            queue.offer(nn);
          }
        }

        count++;
      }
    }
    return count;
  }
}

package javaps.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlphabetTree {

  static int min = Integer.MAX_VALUE;
  static int max = Integer.MIN_VALUE;

  public static void init(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine().trim());
    for (int i = 0; i < t; i++) {
      sb.append(br.readLine().trim());
    }
    Pair answer = solution(sb.toString());

    System.out.println(answer.x);
    System.out.println(answer.y);
    br.close();
  }

  public static Pair solution(String base) {
    dfs(base, 0, 0);
    return new Pair(min, max);
  }

  public static void dfs(String nodes, int cur, int acc) {
    if (cur >= nodes.length()) {
      min = Math.min(min, acc);
      max = Math.max(max, acc);
      return;
    }

    int nextAcc = acc + nodes.charAt(cur) - 'A' + 1;
    dfs(nodes, cur * 2 + 1, nextAcc);
    dfs(nodes, cur * 2 + 2, nextAcc);
  }

  public static class Node {
    int pos;
    int value;

    public Node(int pos, char value) {
      this.pos = pos;
      this.value = value - 'A' + 1;
    }
  }

  public static class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}

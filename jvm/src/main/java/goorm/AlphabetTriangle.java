package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlphabetTriangle {

  static int[] dp = null;

  public static void init(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine().trim());
    for (int i = 0; i < t; i++) {
      sb.append(br.readLine().trim());
    }
    String param = sb.toString();
    int answer = solution(param);

    System.out.println(answer);
    br.close();
  }

  public static int solution(String base) {
    dp = new int[base.length()];
    dfs(base, 0, 1);
    return dp[0];
  }

  public static int dfs(String nodes, int cur, int depth) {
    if (dp[cur] != 0) {
      return dp[cur];
    }
    int nextLeft = cur + depth;
    if (!canMove(nodes, nextLeft)) {
      return dp[cur] = getBlockId(nodes.charAt(cur));
    }
    return dp[cur] =
        Math.max(
            dp[cur],
            getBlockId(nodes.charAt(cur))
                + Math.max(dfs(nodes, nextLeft, depth + 1), dfs(nodes, nextLeft + 1, depth + 1)));
  }

  public static boolean canMove(String nodes, int pos) {
    return pos < nodes.length();
  }

  public static int getBlockId(char ch) {
    return ch - 'A' + 1;
  }
}

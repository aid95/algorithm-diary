package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JumpJump {

  private static int[] stones;
  private static final boolean[] visited = new boolean[100_001];
  private static int count = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    stones = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    dfs(Integer.parseInt(br.readLine().trim()) - 1);
    System.out.println(count);
  }

  public static void dfs(int current) {
    if (checkRange(current) && !isVisited(current)) {
      visited[current] = true;
      count++;
      dfs(current + stones[current]);
      dfs(current - stones[current]);
    }
  }

  private static boolean checkRange(int index) {
    return 0 <= index && index < stones.length;
  }

  private static boolean isVisited(int index) {
    return visited[index];
  }
}

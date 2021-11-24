package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Downhill {

  private static final int[] dx = new int[] {0, -1, 1};
  private static final int[] dy = new int[] {1, 0, 0};

  private static int[][] map;
  private static int[][] dp;

  public static void entryPoint(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] mn = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    map = new int[mn[0]][mn[1]];
    dp = new int[mn[0]][mn[1]];
    for (int i = 0; i < mn[0]; i++) {
      dp[i] = new int[mn[1]];
      Arrays.fill(dp[i], -1);
      map[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    System.out.println(solution());
  }

  public static int solution() {
    return dfs(0, 0);
  }

  private static int dfs(int x, int y) {
    if (x == (map[0].length - 1) && y == (map.length - 1)) {
      return 1;
    } else if (dp[y][x] == -1) {
      dp[y][x] = 0;
      for (int i = 0; i < 3; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (0 <= nx
            && nx < map[0].length
            && 0 <= ny
            && ny < map.length
            && map[y][x] > map[ny][nx]) {
          dp[y][x] += dfs(nx, ny);
        }
      }
    }
    return dp[y][x];
  }
}

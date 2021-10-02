package test.coding.algorithm.programmers;

import test.coding.algorithm.Solution;

public class GameMapShortestPath implements Solution {

  @Override
  public void solve() {
    System.out.println(
        solution(
            new int[][] {
              {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}
            }));
  }

  private final int[] dx = new int[] {0, 0, -1, 1};
  private final int[] dy = new int[] {-1, 1, 0, 0};
  private int answer = -1;

  public int solution(int[][] maps) {
    int w = maps[0].length;
    int h = maps.length;
    dfs(maps, new boolean[h][w], 0, 0, 1);
    return answer;
  }

  public void dfs(int[][] maps, boolean[][] visited, int x, int y, int count) {
    visited[y][x] = true;

    if (x == (maps[0].length - 1) && y == (maps.length - 1)) {
      if (answer != -1) {
        answer = Math.min(answer, count);
      } else {
        answer = count;
      }
      return;
    }

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if ((0 <= nx && nx < maps[0].length)
          && (0 <= ny && ny < maps.length)
          && !visited[ny][nx]
          && maps[ny][nx] != 0) {
        dfs(maps, visited, nx, ny, count + 1);
        visited[ny][nx] = false;
      }
    }
  }
}

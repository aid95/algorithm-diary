package test.coding.algorithm.programmers;

import test.coding.algorithm.Solution;

import java.util.LinkedList;
import java.util.Queue;

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

  public int solution(int[][] maps) {
    return bfs(maps);
  }

  public int bfs(int[][] maps) {
    Queue<Player> q = new LinkedList<>();
    int width = maps[0].length;
    int height = maps.length;
    boolean[][] visited = new boolean[height][width];

    q.offer(new Player(0, 0, 1));
    visited[0][0] = true;
    while (!q.isEmpty()) {
      Player player = q.poll();

      if ((player.x == width - 1) && (player.y == height - 1)) {
        return player.count;
      }

      for (int i = 0; i < 4; i++) {
        int nx = player.x + dx[i];
        int ny = player.y + dy[i];

        if ((0 <= nx && nx < width)
            && (0 <= ny && ny < height)
            && !visited[ny][nx]
            && maps[ny][nx] == 1) {
          visited[ny][nx] = true;
          q.offer(new Player(nx, ny, player.count + 1));
        }
      }
    }
    return -1;
  }

  class Player {
    public int x;
    public int y;
    public int count;

    public Player(int x, int y, int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }
  }
}

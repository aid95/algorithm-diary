package test.coding.algorithm.boj.makeMaze;

import test.coding.algorithm.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MakeMaze implements Solution {

  @Override
  public void solve() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      int N = Integer.parseInt(br.readLine().trim());
      int[][] maze = new int[N][N];
      for (int i = 0; i < N; i++) {
        String[] tc = br.readLine().trim().split("");
        for (int j = 0; j < N; j++) {
          maze[i][j] = Integer.parseInt(tc[j]);
        }
      }
      System.out.println(bfs(maze, N));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static int bfs(int[][] maze, int mazeWH) {
    int[] dx = new int[] {0, 0, -1, 1};
    int[] dy = new int[] {1, -1, 0, 0};

    int[][] visited = new int[mazeWH][mazeWH];
    for (int i = 0; i < mazeWH; i++) {
      for (int j = 0; j < mazeWH; j++) {
        visited[i][j] = Integer.MAX_VALUE;
      }
    }
    Queue<Pos> posQueue = new LinkedList<>();

    visited[0][0] = 0;
    posQueue.add(new Pos(0, 0));
    while (!posQueue.isEmpty()) {
      int x = posQueue.peek().x;
      int y = posQueue.peek().y;
      posQueue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (0 <= nx && 0 <= ny && nx < mazeWH && ny < mazeWH) {
          if (maze[ny][nx] == 1) {
            if (visited[ny][nx] > visited[y][x]) {
              visited[ny][nx] = visited[y][x];
              posQueue.add(new Pos(nx, ny));
            }
          } else {
            if (visited[ny][nx] > (visited[y][x] + 1)) {
              visited[ny][nx] = visited[y][x] + 1;
              posQueue.add(new Pos(nx, ny));
            }
          }
        }
      }
    }

    return visited[mazeWH - 1][mazeWH - 1];
  }

  public static class Pos {
    public int x;
    public int y;

    public Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}

package test.coding.algorithm.boj.crushWall;

import test.coding.algorithm.Solution;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class CrushWall implements Solution {

  @Override
  public void solve() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    try {
      List<Integer> nm =
          Arrays.stream(br.readLine().trim().split(" "))
              .map(Integer::parseInt)
              .collect(Collectors.toList());
      int[][] board = new int[nm.get(0) + 1][nm.get(1) + 1];
      for (int i = 1; i <= nm.get(0); i++) {
        String[] s = br.readLine().trim().split("");
        for (int j = 1; j <= nm.get(1); j++) {
          board[i][j] = Integer.parseInt(s[j - 1]);
        }
      }
      System.out.println(bfs(nm.get(0), nm.get(1), board));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static int bfs(int n, int m, int[][] board) {
    int[] dx = new int[] {-1, 1, 0, 0};
    int[] dy = new int[] {0, 0, -1, 1};
    int[][][] visited = new int[n + 1][m + 1][2];
    Queue<Pos> queue = new LinkedList<>();

    queue.add(new Pos(1, 1, 1));
    visited[1][1][1] = 1;
    while (!queue.isEmpty()) {
      Pos curPos = queue.poll();
      if (curPos.x == m && curPos.y == n) {
        return visited[curPos.y][curPos.x][curPos.c];
      }
      for (int i = 0; i < 4; i++) {
        int nx = curPos.x + dx[i];
        int ny = curPos.y + dy[i];
        if ((0 < nx && nx <= m) && (0 < ny && ny <= n)) {
          if (curPos.c == 1 && board[ny][nx] == 1) {
            visited[ny][nx][0] = visited[curPos.y][curPos.x][1] + 1;
            queue.add(new Pos(nx, ny, 0));
          } else if (board[ny][nx] == 0 && visited[ny][nx][curPos.c] == 0) {
            visited[ny][nx][curPos.c] = visited[curPos.y][curPos.x][curPos.c] + 1;
            queue.add(new Pos(nx, ny, curPos.c));
          }
        }
      }
    }
    return -1;
  }

  public static class Pos {
    public int x;
    public int y;
    public int c;

    public Pos(int x, int y, int c) {
      this.x = x;
      this.y = y;
      this.c = c;
    }
  }
}

package test.coding.algorithm.programmers;

import test.coding.algorithm.Solution;

import java.util.Arrays;
import java.util.Stack;

public class ColoringBook implements Solution {

  @Override
  public void solve() {
    System.out.println(
        Arrays.toString(
            solution(
                6,
                4,
                new int[][] {
                  {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}
                })));
  }

  public int[] solution(int m, int n, int[][] picture) {
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    int[] dx = new int[] {0, 0, -1, 1};
    int[] dy = new int[] {1, -1, 0, 0};
    boolean[][] isVisited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (picture[i][j] == 0 || isVisited[i][j]) continue;

        numberOfArea += 1;
        int count = 1;
        int color = picture[i][j];
        Stack<Pos> stack = new Stack<>();

        stack.add(new Pos(j, i));
        while (!stack.isEmpty()) {
          Pos current = stack.pop();
          isVisited[i][j] = true;

          for (int k = 0; k < 4; k++) {
            int nx = current.x + dx[k];
            int ny = current.y + dy[k];

            if ((0 <= nx && nx < n)
                && (0 <= ny && ny < m)
                && !isVisited[ny][nx]
                && picture[ny][nx] == color) {
              count += 1;
              isVisited[ny][nx] = true;
              stack.push(new Pos(nx, ny));
            }
          }
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
      }
    }

    int[] answer = new int[2];
    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;
    return answer;
  }

  public class Pos {
    public int x;
    public int y;

    public Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}

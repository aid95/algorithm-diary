package javaps.programmers;

import java.util.Arrays;

public class Hopscotch {

  int solution(int[][] land) {
    int row = land.length;
    int[][] dp = new int[row][4];

    dp[0][0] = land[0][0];
    dp[0][1] = land[0][1];
    dp[0][2] = land[0][2];
    dp[0][3] = land[0][3];

    for (int i = 1; i < row; i++) {
      for (int j = 0; j < 4; j++) {
        for (int k = 0; k < 4; k++) {
          if (j != k) {
            dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][k]);
          }
        }
      }
    }

    return Arrays.stream(dp[row - 1]).max().orElse(0);
  }
}

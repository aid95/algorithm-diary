package javaps.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Coin {

  public static void init() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    final long[] coins =
        Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
    System.out.println(solution(coins));
  }

  public static long solution(long[] coins) {
    long[] dp = new long[coins.length];
    dp[0] = coins[0];
    for (int i = 1; i < coins.length; i++) {
      dp[i] = Math.max(coins[i], dp[i - 1] + coins[i]);
    }
    return Arrays.stream(dp).max().orElse(-1);
  }
}

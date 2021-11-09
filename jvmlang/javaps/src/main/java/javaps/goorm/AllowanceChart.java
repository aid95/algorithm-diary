package javaps.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class AllowanceChart {

  public static void init(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] t = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] allowances =
        Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    for (int i = 0; i < t[1]; i++) {
      int[] params =
          Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
      int result = solution(allowances, params[0], params[1]);
      if (result > 0) {
        System.out.println("+" + result);
      } else {
        System.out.println(result);
      }
    }
  }

  public static int solution(int[] allowances, int start, int end) {
    return IntStream.rangeClosed(start - 1, end - 1).reduce(0, (x, y) -> x + allowances[y]);
  }
}

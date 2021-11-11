package javaps.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CuttingPaper {

  static Long answer = 0L;

  public static void init(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    var wh = Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
    solution(wh[0], wh[1]);
    System.out.println(answer);
  }

  public static void solution(Long width, Long height) {
    while (width >= 20 && height >= 40) {
      answer += width / 20;
      height -= 40;
      if (width > height) {
        Long tmp = width;
        width = height;
        height = tmp;
      }
    }
  }
}

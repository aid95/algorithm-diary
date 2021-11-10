package javaps.goorm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class AllowanceChart {

  private static BigInteger[] accumulation = null;

  public static void init(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int[] t = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] allowances =
        Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

    accumulation = new BigInteger[allowances.length];
    accumulation[0] = BigInteger.valueOf(allowances[0]);
    for (int i = 1; i < allowances.length; i++) {
      accumulation[i] = BigInteger.valueOf(allowances[i]).add(accumulation[i - 1]);
    }

    for (int i = 0; i < t[1]; i++) {
      int[] params =
          Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
      BigInteger result = solution(allowances, params[0], params[1]);
      if (result.compareTo(BigInteger.ZERO) > 0) {
        sb.append("+").append(result).append('\n');
      } else {
        sb.append(result).append('\n');
      }
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  public static BigInteger solution(int[] allowances, int start, int end) {
    return accumulation[end - 1]
        .subtract(accumulation[start - 1])
        .add(BigInteger.valueOf(allowances[start - 1]));
  }
}

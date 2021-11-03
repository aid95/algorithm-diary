package javaps.baekjoon;

import javaps.Solution;

import java.io.*;
import java.util.StringTokenizer;

public class Bridge implements Solution {

  private static final int[][] mem = new int[31][31];

  @Override
  public void run() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    try {
      int t = Integer.parseInt(br.readLine().trim());
      for (int i = 0; i < t; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int r = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        sb.append(dp(n, r)).append('\n');
      }

      bw.write(sb.toString());
      bw.flush();
      bw.close();
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static int dp(int n, int r) {
    if (mem[n][r] > 0) {
      return mem[n][r];
    }
    if (n == r || r == 0) {
      return mem[n][r] = 1;
    }
    return mem[n][r] = dp(n - 1, r - 1) + dp(n - 1, r);
  }
}

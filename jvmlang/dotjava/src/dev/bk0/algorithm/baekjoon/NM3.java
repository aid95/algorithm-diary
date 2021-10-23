package dev.bk0.algorithm.baekjoon;

import dev.bk0.algorithm.Solution;

import java.io.*;
import java.util.StringTokenizer;

public class NM3 implements Solution {

  private static int N = 0;
  private static int M = 0;
  private static BufferedWriter bw = null;
  private static BufferedReader br = null;

  @Override
  public void run() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    try {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      bt(0, "");
      bw.flush();
      bw.close();
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void bt(int dept, String seq) throws IOException {
    if (dept == M) {
      bw.write(seq.substring(1) + "\n");
    } else {
      for (int i = 1; i <= N; i++) {
        bt(dept + 1, seq + " " + i);
      }
    }
  }
}

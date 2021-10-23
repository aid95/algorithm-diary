package dev.bk0.algorithm.baekjoon;

import dev.bk0.algorithm.Solution;

import java.io.*;
import java.util.StringTokenizer;

public class TotalSubSequence implements Solution {

  private static int N = 0;
  private static int S = 0;
  private static int count = 0;

  @Override
  public void run() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    try {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      S = Integer.parseInt(st.nextToken());
      int[] seq = new int[N];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        seq[i] = Integer.parseInt(st.nextToken());
      }
      if (S == 0) {
        count--;
      }
      bt(seq, 0, 0);
      bw.write(String.valueOf(count));
      bw.flush();
      bw.close();
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void bt(int[] sequence, int pos, int acc) {
    if (pos == N) {
      if (acc == S) {
        count++;
      }
      return;
    }
    bt(sequence, pos + 1, acc);
    bt(sequence, pos + 1, acc + sequence[pos]);
  }
}

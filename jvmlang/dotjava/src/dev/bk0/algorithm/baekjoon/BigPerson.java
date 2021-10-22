package dev.bk0.algorithm.baekjoon;

import dev.bk0.algorithm.Solution;

import java.io.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class BigPerson implements Solution {

  @Override
  public void run() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringJoiner sj = new StringJoiner(" ");

    try {
      int N = Integer.parseInt(br.readLine());
      int[][] records = new int[N][2];
      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        records[i][0] = w;
        records[i][1] = h;
      }

      for (int i = 0; i < N; i++) {
        int order = 1;
        for (int j = 0; j < N; j++) {
          if (records[i][0] < records[j][0] && records[i][1] < records[j][1]) {
            order += 1;
          }
        }
        sj.add(String.valueOf(order));
      }

      bw.write(sj.toString());
      bw.flush();
      bw.close();
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

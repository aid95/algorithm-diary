package test.coding.algorithm.boj;

import test.coding.algorithm.Solution;

import java.io.*;
import java.util.StringTokenizer;

public class WaterBottle implements Solution {

  @Override
  public void solve() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    try {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      int answer = 0;
      if (N > K) {
        while (true) {
          int num = N;
          int count = 0;
          do {
            if (num % 2 == 1) count += 1;
            num /= 2;
          } while (num != 0);
          if (count <= K) break;
          N += 1;
          answer += 1;
        }
      }

      bw.write(answer + "\n");
      bw.flush();
      bw.close();
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

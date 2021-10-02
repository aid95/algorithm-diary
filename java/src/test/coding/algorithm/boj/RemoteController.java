package test.coding.algorithm.boj;

import test.coding.algorithm.Solution;

import java.io.*;
import java.util.Arrays;

public class RemoteController implements Solution {

  @Override
  public void solve() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    try {
      int channel = Integer.parseInt(br.readLine().trim());
      br.readLine();
      boolean[] buttons = new boolean[10];
      Arrays.fill(buttons, true);
      Arrays.stream(br.readLine().trim().split(" "))
          .mapToInt(Integer::parseInt)
          .forEach(x -> buttons[x] = false);
      int answer = bf(channel, buttons);
      System.out.println(answer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public int bf(int channel, boolean[] buttons) {
    int answer = Math.abs(channel - 100);
    for (int i = 0; i <= 500_000; i++) {
      if (isPossible(buttons, i)) {
        int numberOfClicking = String.valueOf(i).length();
        answer = Math.min(answer, Math.abs(channel - i) + numberOfClicking);
      }
    }
    return answer;
  }

  public boolean isPossible(boolean[] buttons, int channel) {
    String s = String.valueOf(channel);
    int length = s.length();
    for (int i = 0; i < length; i++) {
      if (!buttons[s.charAt(i) - '0']) {
        return false;
      }
    }
    return true;
  }
}

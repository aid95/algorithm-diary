package javaps.baekjoon;

import javaps.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Radio implements Solution {

  @Override
  public void run() {
    Scanner scanner = new Scanner(System.in);

    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int n = scanner.nextInt();
    List<Integer> buttons = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      buttons.add(scanner.nextInt());
    }

    System.out.println(solution(a, b, buttons));
  }

  public static int solution(int cur, int goal, List<Integer> quickButtons) {
    int maxHit = Math.abs(cur - goal);

    int minHit =
        quickButtons.stream()
                .mapToInt(x -> x)
                .map(x -> Math.abs(goal - x))
                .min()
                .orElse(Integer.MAX_VALUE - 1)
            + 1;

    return Math.min(maxHit, minHit);
  }
}

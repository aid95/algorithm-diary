package javaps.goorm;

import java.util.Scanner;

public class ThreeStar {

  public static void init(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    Star[] stars = new Star[3];
    stars[0] = new Star(scanner.nextInt(), scanner.nextInt());
    stars[1] = new Star(scanner.nextInt(), scanner.nextInt());
    stars[2] = new Star(scanner.nextInt(), scanner.nextInt());
    System.out.printf("%.02f", solution(stars));
  }

  private static double solution(Star[] stars) {
    int a = stars[0].x;
    int d = stars[0].y;
    int b = stars[1].x;
    int e = stars[1].y;
    int c = stars[2].x;
    int f = stars[2].y;

    double result = ((a * e + b * f + c * d) - (d * b + e * c + f * a)) * 0.5;
    if (result < 0) {
      result *= -1;
    }
    return result;
  }

  private static class Star {
    int x;
    int y;

    public Star(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}

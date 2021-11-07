package javaps.goorm;

public class InSsaMinsu {

  public static int solution(int a, int b) {
    if (a != b) {
      return 2;
    }
    return divisor(a);
  }

  public static int divisor(int num) {
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        return i;
      }
    }
    return num;
  }
}

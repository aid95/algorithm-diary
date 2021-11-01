package javaps.programmers;

public class BaseNGame {

  public String solution(int n, int t, int m, int p) {
    int cnt = 0;
    int cur = 0;
    int turn = 0;
    StringBuilder sb = new StringBuilder();

    while (cnt < t) {
      char[] base = convert(cur, n).toUpperCase().toCharArray();
      for (char ch : base) {
        if ((cnt < t) && turn == (p - 1)) {
          sb.append(ch);
          cnt++;
        }
        turn = (turn + 1) % m;
      }
      cur++;
    }
    return sb.toString();
  }

  private String convert(int n, int base) {
    return Integer.toString(n, base);
  }
}

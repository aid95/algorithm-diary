package javaps.goorm;

public class Winner {

  public static boolean solution(String history) {
    int historyLength = history.length();
    boolean[] flags = new boolean[2];
    for (int i = 0; i < historyLength; i++) {
      char ch = history.charAt(i);
      if (((i + 1) < historyLength)) {
        if (!flags[0] && ch == '1' && history.charAt(i + 1) == '2') {
          flags[0] = true;
          i++;
        } else if (!flags[1] && ch == '2' && history.charAt(i + 1) == '1') {
          flags[1] = true;
          i++;
        }
      }
    }
    return flags[0] && flags[1];
  }
}

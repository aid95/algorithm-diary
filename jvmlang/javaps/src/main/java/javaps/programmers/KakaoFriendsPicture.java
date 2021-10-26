package javaps.programmers;

public class KakaoFriendsPicture {

  private final String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
  private final boolean[] visited = new boolean[8];
  private String[] conditions = null;
  private int answer = 0;
  private int count = 0;

  public int solution(int n, String[] data) {
    conditions = data;
    bt("");
    System.out.println(count);
    return answer;
  }

  private void bt(String line) {
    count++;
    if (line.length() == 8) {
      if (valid(line)) {
        answer += 1;
      }
    } else {
      for (int i = 0; i < 8; i++) {
        if (!visited[i]) {
          visited[i] = true;
          bt(line + friends[i]);
          visited[i] = false;
        }
      }
    }
  }

  private boolean valid(String line) {
    for (var cond : conditions) {
      int l = line.indexOf(cond.charAt(0));
      int r = line.indexOf(cond.charAt(2));
      int op = cond.charAt(3);
      int d = cond.charAt(4) - '0' + 1;
      int dd = Math.abs(l - r);

      switch (op) {
        case '=':
          if (dd != d) {
            return false;
          }
          break;
        case '>':
          if (dd <= d) {
            return false;
          }
          break;
        case '<':
          if (dd >= d) {
            return false;
          }
          break;
      }
    }
    return true;
  }
}

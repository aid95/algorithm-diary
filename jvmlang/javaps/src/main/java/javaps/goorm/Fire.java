package javaps.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Fire {

  public static void init(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] RC = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    String[] map = new String[RC[1]];
    Tile startTile = null;
    for (int i = 0; i < RC[1]; i++) {
      String l = br.readLine().trim();
      if (startTile == null && l.contains("&")) {
        startTile = new Tile(l.indexOf("&"), i, 0);
      }
      map[i] = l;
    }

    System.out.println(solution(map, startTile));
  }

  public static int solution(String[] map, Tile start) {
    final int mapWidth = map[0].length();
    final int mapHeight = map.length;
    final int[] dx = {0, 0, -1, 1};
    final int[] dy = {-1, 1, 0, 0};
    boolean[][] visited = new boolean[mapHeight][mapWidth];

    Queue<Tile> tileQueue = new LinkedList<>();
    tileQueue.offer(start);
    while (!tileQueue.isEmpty()) {
      Tile currentTile = tileQueue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = currentTile.x + dx[i];
        int ny = currentTile.y + dy[i];
        if ((0 <= nx && nx < mapWidth) && (0 <= ny && ny < mapHeight) && !visited[ny][nx]) {
          char tileType = map[ny].charAt(nx);
          if (tileType == '#') {
            continue;
          }
          if (tileType == '.') {
            tileQueue.offer(new Tile(nx, ny, currentTile.seconds + 1));
          } else if (tileType == '@') {
            return currentTile.seconds;
          }
          visited[ny][nx] = true;
        }
      }
    }

    return -1;
  }

  private static class Tile {
    int x;
    int y;
    int seconds;

    public Tile(int x, int y, int seconds) {
      this.x = x;
      this.y = y;
      this.seconds = seconds;
    }
  }
}

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Sheep {

    private static final int[] dx = { 0, 0, -1, 1 };
    private static final int[] dy = { -1, 1, 0, 0 };
    private static String[] map = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rc = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        map = new String[rc[0]];
        for (int i = 0; i < rc[0]; i++) {
            map[i] = br.readLine().trim();
        }

        bfs(map);
    }

    private static void bfs(String[] map) {
        boolean[][] visited = new boolean[map.length][map[0].length()];
        Queue<Point> q = new LinkedList<>();
        int totalSheepNum = 0;
        int totalWolfNum = 0;

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length(); x++) {
                if (!visited[y][x] && (map[y].charAt(x) == 'o' || map[y].charAt(x) == 'v')) {
                    int sheep = 0;
                    int wolf = 0;
                    if (map[y].charAt(x) == 'v') {
                        wolf++;
                    } else {
                        sheep++;
                    }
                    q.offer(new Point(x, y));
                    visited[y][x] = true;
                    while (!q.isEmpty()) {
                        Point point = q.poll();
                        for (int i = 0; i < 4; i++) {
                            int _x = point.x + dx[i];
                            int _y = point.y + dy[i];
                            if (canMove(_x, _y) && !visited[_y][_x] && map[_y].charAt(_x) != '#') {
                                char type = map[_y].charAt(_x);
                                if (type == 'v') {
                                    wolf++;
                                } else if (type == 'o') {
                                    sheep++;
                                }
                                visited[_y][_x] = true;
                                q.offer(new Point(_x, _y));
                            }
                        }
                    }
                    if (sheep > wolf) {
                        totalSheepNum += sheep;
                    } else {
                        totalWolfNum += wolf;
                    }
                }
            }
        }
        System.out.print(totalSheepNum + " " + totalWolfNum);
    }

    private static boolean canMove(int x, int y) {
        return 0 <= x && x < map[0].length() && 0 <= y && y < map.length;
    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

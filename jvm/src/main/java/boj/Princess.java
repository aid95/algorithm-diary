package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Princess {

    private static int[][] map;

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());
        final int t = Integer.parseInt(st.nextToken());

        map = new int[n][];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        int result = bfs(CastleFactory.build(map, t));
        if (result == -1) {
            System.out.println("Fail");
            return;
        }
        System.out.println(result);
    }

    private static int bfs(Castle castle) {
        Queue<Warrior> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[map.length][map[0].length][2];

        visited[0][0][0] = true;
        // normal
       
        while (!q.isEmpty()) {
            Warrior current = q.poll();

            for (int i = 0; i < 4; i++) {
                Warrior next = current.move(dx[i], dy[i]);

                if (castle.isMove(next)) {
                    q.offer(next);
                }
            }
        }

        return -1;
    }

    private static boolean canMove(int x, int y) {
        return 0 <= x && x < map[0].length && 0 <= y
            && y < map.length;
    }

    private static boolean isGoal(Player player) {
        return player.getX() == (map[0].length - 1) && player.getY() == (map.length - 1);
    }

    private static class Player {

        private final int x;
        private final int y;
        private final boolean gram;
        private final int step;

        public Player(int x, int y, int step, boolean gram) {
            this.x = x;
            this.y = y;
            this.gram = gram;
            this.step = step;
        }

        public int getStep() {
            return step;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isGram() {
            return gram;
        }
    }

    private static class CastleFactory {

        public static Castle build(int[][] blueprint, int limitTime) {
            return new Castle(toTiles(blueprint), limitTime);
        }

        private static Tile[][] toTiles(int[][] blueprint) {
            Tile[][] tiles = new Tile[blueprint.length][blueprint[0].length];
            for (int i = 0; i < blueprint.length; i++) {
                for (int j = 0; j < blueprint[0].length; j++) {
                    tiles[i][j] = Tile.values()[blueprint[i][j]];
                }
            }
            return tiles;
        }
    }

    private static class Castle {

        private final Tile[][] tiles;
        private final int limitTime;

        public Castle(Tile[][] tiles, int limitTime) {
            this.tiles = tiles;
            this.limitTime = limitTime;
        }

        public boolean isMove(Warrior warrior) {
            if (!warrior.inRange(this.tiles[0].length, this.tiles.length) &&
                !warrior.isTimeOver(limitTime)) {
                return false;
            }
            return true;
        }
    }

    private enum Tile {
        EMPTY,
        WALL,
        GRAM,
    }

    private static abstract class Warrior {

        protected final int x;
        protected final int y;
        protected final int time;

        public Warrior(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public boolean isTimeOver(int time) {
            return this.time > time;
        }

        public boolean inRange(int w, int h) {
            return 0 <= x && x < w && 0 <= h && h < y;
        }

        public abstract Warrior move(int x, int y);

        public boolean canMove;
    }
}

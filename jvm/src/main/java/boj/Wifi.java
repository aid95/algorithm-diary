package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Wifi {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Houses houses = new Houses();
        for (int i = 0; i < n; i++) {
            houses.addHouse(new House(Integer.parseInt(br.readLine().trim())));
        }

        Engineer engineer = new Engineer(c);
        System.out.println(engineer.setup(houses));
    }

    private static class Engineer {

        private final int wifiNum;

        public Engineer(int wifiNum) {
            this.wifiNum = wifiNum;
        }

        public int setup(Houses houses) {
            Houses sortedHouses = houses.sortedHouses();
            int answer = 0;
            int s = 1;
            int e =
                sortedHouses.getHouse(sortedHouses.size() - 1)
                    .distance(sortedHouses.getHouse(0));
            while (s <= e) {
                int mid = (s + e) / 2;
                int setupCount = setup(sortedHouses, mid);
                if (setupCount >= this.wifiNum) {
                    answer = mid;
                    s = mid + 1;
                    continue;
                }
                e = mid - 1;
            }
            return answer;
        }

        private int setup(Houses houses, int gap) {
            int result = 1;
            House base = houses.getHouse(0);
            int len = houses.size();
            for (int i = 1; i < len; i++) {
                if (isPossible(houses.getHouse(i).distance(base), gap)) {
                    result++;
                    base = houses.getHouse(i);
                }
            }
            return result;
        }

        private boolean isPossible(int distance, int gap) {
            return distance >= gap;
        }
    }

    private static class Houses {

        private List<House> houses = new ArrayList<>();

        public Houses() {

        }

        public Houses(List<House> houses) {
            this.houses = houses;
        }

        public void addHouse(House house) {
            this.houses.add(house);
        }

        public Houses sortedHouses() {
            return new Houses(
                new ArrayList<>(this.houses.stream().sorted().collect(Collectors.toList())));
        }

        public House getHouse(int i) {
            return new House(this.houses.get(i).getPos());
        }

        public int size() {
            return this.houses.size();
        }
    }

    private static class House implements Comparable<House> {

        private int pos;

        public House(int pos) {
            if (pos < 0) {
                throw new IllegalArgumentException();
            }
            this.pos = pos;
        }

        public int getPos() {
            return pos;
        }

        public int distance(House o) {
            return Math.abs(this.pos - o.pos);
        }

        @Override
        public int compareTo(House o) {
            return this.pos - o.pos;
        }
    }
}

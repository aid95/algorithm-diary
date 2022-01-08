package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        int start = (int) Math.pow(10, t - 1);
        int end = (int) Math.pow(10, t) - 1;

        for (int i = start; i <= end; i++) {
            Num num = new Num(i);
            if (num.isRightTruncatablePrime()) {
                sb.append(num.getValue()).append(' ');
            }
        }
        System.out.println(sb);
    }

    private static class Num {

        private final int value;

        public Num(int value) {
            this.value = value;
        }

        public boolean isRightTruncatablePrime() {
            int tmp = this.value;
            do {
                if (!isPrime(tmp)) {
                    return false;
                }
                tmp /= 10;
            } while (tmp > 0);
            return true;
        }

        private boolean isPrime(int value) {
            if (value <= 1) {
                return false;
            }

            if (value % 2 == 0) {
                return value == 2;
            }

            int e = (int) Math.sqrt((double) value);
            for (int i = 3; i <= e; i++) {
                if (value % i == 0) {
                    return false;
                }
            }

            return true;
        }

        public int getValue() {
            return value;
        }
    }
}

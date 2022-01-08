package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = start; i <= end; i++) {
            answer += new SplitNum(i).getValue();
        }
        System.out.println(answer);
    }

    private static class SplitNum {

        public static final SplitNum ZeroSplitNum = new SplitNum(0);

        private final int value;

        public SplitNum(int value) {
            this.value = split(value);
        }

        private int split(int n) {
            if (n == 0) {
                return 0;
            }

            int result = 1;
            while (n > 0) {
                result *= n % 10;
                n /= 10;
            }
            return result;
        }

        public int getValue() {
            return value;
        }
    }
}

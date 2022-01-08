package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        int answer = 0;
        for (int i = 0; i < t; i++) {
            if (is(Double.parseDouble(br.readLine().trim()))) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean is(double n) {
        double tmp = Math.pow(n, 0.5);
        if ((int) tmp == tmp) {
            return Math.pow(tmp, 2) == n;
        }
        return false;
    }
}

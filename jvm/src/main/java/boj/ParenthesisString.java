package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParenthesisString {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < t; i++) {
            String ps = br.readLine().trim();
            if (check(ps)) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }

    private static boolean check(String ps) {
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < ps.length(); j++) {
            char ch = ps.charAt(j);
            if (ch == '(') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty() || stack.peek() != '(') {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}

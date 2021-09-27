package test.coding.algorithm.boj;

import test.coding.algorithm.Solution;

import java.io.*;
import java.util.Stack;

public class BalancedWorld implements Solution {

  @Override
  public void solve() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    try {
      while (true) {
        String tc = br.readLine();
        if (tc.length() == 1 && tc.toCharArray()[0] == '.') {
          break;
        }
        bw.write(check(tc) ? "yes\n" : "no\n");
      }
      bw.flush();
      bw.close();
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean check(String s) {
    Stack<Character> stack = new Stack<>();
    char[] c = s.toCharArray();
    int length = s.length();
    for (int i = 0; i < length; i++) {
      if (c[i] == '(') {
        stack.push('(');
      } else if (c[i] == '[') {
        stack.push('[');
      }

      if (c[i] == ')') {
        if (stack.isEmpty() || stack.pop() != '(') {
          return false;
        }
      } else if (c[i] == ']') {
        if (stack.isEmpty() || stack.pop() != '[') {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}

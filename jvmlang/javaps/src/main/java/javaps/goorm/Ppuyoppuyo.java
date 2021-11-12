package javaps.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Ppuyoppuyo {

  public static void init(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] nm = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    String input = br.readLine().trim();
    String result = solution(input, nm[1]);
    if (result.length() == 0) {
      System.out.println("CLEAR!");
      return;
    }
    System.out.println(result);
  }

  public static String solution(String blockSeq, int hitCount) {
    blockSeq += "."; // last chance trigger

    int len = blockSeq.length();
    Stack<Block> stack = new Stack<>();
    int loopCount = 0;
    while (loopCount < len) {
      char blockId = blockSeq.charAt(loopCount);
      if (!stack.isEmpty() && stack.peek().id == blockId) {
        Block updateBlock = stack.pop();
        updateBlock.comboCount++;
        stack.push(updateBlock);
      } else if (stack.isEmpty() || stack.peek().comboCount < hitCount) {
        stack.push(new Block(blockId, 1));
      } else {
        stack.pop();
        continue;
      }
      loopCount++;
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      Block block = stack.pop();
      sb.insert(0, String.valueOf(block.id).repeat(block.comboCount));
    }
    String result = sb.toString();
    return result.substring(0, result.length() - 1);
  }

  public static class Block {
    char id;
    int comboCount;

    public Block(char id, int comboCount) {
      this.id = id;
      this.comboCount = comboCount;
    }
  }
}

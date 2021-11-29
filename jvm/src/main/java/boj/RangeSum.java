package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class RangeSum {

  private static BigInteger[] sequenceNums = null;
  private static BigInteger[] tree = null;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] nmk = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
        .toArray();

    sequenceNums = new BigInteger[nmk[0]];
    for (int i = 0; i < nmk[0]; i++) {
      sequenceNums[i] = new BigInteger(br.readLine().trim());
    }

    tree = new BigInteger[nmk[0] * 4];
    initTree(0, nmk[0] - 1, 1);

    for (int i = 0; i < (nmk[1] + nmk[2]); i++) {
      String[] abc = br.readLine().trim().split(" ");
      if (abc[0].equals("1")) {
        int pos = Integer.parseInt(abc[1]) - 1;
        BigInteger gap = new BigInteger(abc[2]).subtract(
            sequenceNums[pos]);
        sequenceNums[pos] = new BigInteger(abc[2]);
        updateTree(0, nmk[0] - 1, 1, pos, gap);
      } else {
        int x = Integer.parseInt(abc[1]) - 1;
        int y = Integer.parseInt(abc[2]) - 1;
        System.out.println(rangeSum(0, nmk[0] - 1, 1, x, y));
      }
    }
  }

  public static BigInteger initTree(int begin, int end, int root) {
    if (begin == end) {
      return tree[root] = sequenceNums[begin];
    }
    int mid = (begin + end) / 2;
    return tree[root] = initTree(begin, mid, root * 2).add(initTree(mid + 1, end, root * 2 + 1));
  }

  public static BigInteger rangeSum(int begin, int end, int root, int x, int y) {
    if (y < begin || end < x) {
      return BigInteger.ZERO;
    }

    if (x <= begin && end <= y) {
      return tree[root];
    }

    int mid = (begin + end) / 2;
    return rangeSum(begin, mid, root * 2, x, y).add(rangeSum(mid + 1, end, root * 2 + 1, x, y));
  }

  public static void updateTree(int begin, int end, int root, int target, BigInteger gap) {
    if (begin <= target && target <= end) {
      tree[root] = tree[root].add(gap);
      if (begin != end) {
        int mid = (begin + end) / 2;
        updateTree(begin, mid, root * 2, target, gap);
        updateTree(mid + 1, end, root * 2 + 1, target, gap);
      }
    }
  }
}

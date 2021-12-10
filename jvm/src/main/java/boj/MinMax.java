package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinMax {

  private static long[] maxSegmentTree = null;
  private static long[] minSegmentTree = null;
  private static long[] nums = null;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int[] nm = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    maxSegmentTree = new long[nm[0] * 4];
    minSegmentTree = new long[nm[0] * 4];
    nums = new long[nm[0]];
    for (int i = 0; i < nm[0]; i++) {
      nums[i] = Integer.parseInt(br.readLine().trim());
    }
    setUpMaxSegmentTree(0, nm[0] - 1, 1);
    setUpMinSegmentTree(0, nm[0] - 1, 1);
    for (int i = 0; i < nm[1]; i++) {
      int[] xy = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
          .toArray();
      Long min = getMinNum(0, nm[0] - 1, xy[0] - 1, xy[1] - 1, 1);
      Long max = getMaxNum(0, nm[0] - 1, xy[0] - 1, xy[1] - 1, 1);
      sb.append(min).append(" ").append(max).append('\n');
    }
    System.out.print(sb);
  }

  private static Long setUpMaxSegmentTree(int begin, int end, int root) {
    if (begin == end) {
      return maxSegmentTree[root] = nums[begin];
    }
    int mid = (begin + end) / 2;
    return maxSegmentTree[root] = Math.max(setUpMaxSegmentTree(begin, mid, root * 2),
        setUpMaxSegmentTree(mid + 1, end, root * 2 + 1));
  }

  private static Long setUpMinSegmentTree(int begin, int end, int root) {
    if (begin == end) {
      return minSegmentTree[root] = nums[begin];
    }

    int mid = (begin + end) / 2;
    return minSegmentTree[root] = Math.min(setUpMinSegmentTree(begin, mid, root * 2),
        setUpMinSegmentTree(mid + 1, end, root * 2 + 1));
  }

  private static Long getMaxNum(int begin, int end, int x, int y, int root) {
    if (y < begin || end < x) {
      return -Long.MAX_VALUE;
    }

    if (x <= begin && end <= y) {
      return maxSegmentTree[root];
    }

    int mid = (begin + end) / 2;
    return Math.max(getMaxNum(begin, mid, x, y, root * 2),
        getMaxNum(mid + 1, end, x, y, root * 2 + 1));
  }

  private static Long getMinNum(int begin, int end, int x, int y, int root) {
    if (y < begin || end < x) {
      return Long.MAX_VALUE;
    }

    if (x <= begin && end <= y) {
      return minSegmentTree[root];
    }

    int mid = (begin + end) / 2;
    return Math.min(getMinNum(begin, mid, x, y, root * 2),
        getMinNum(mid + 1, end, x, y, root * 2 + 1));
  }
}

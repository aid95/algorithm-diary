package javaps.leetcode;

public class SingleNumber {

  public int singleNumber(int[] nums) {
    int b = 0;
    for (int num : nums) {
      b ^= num;
    }
    return b;
  }
}

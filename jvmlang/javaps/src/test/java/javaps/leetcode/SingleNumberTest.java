package javaps.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleNumberTest {

  @Test
  void singleNumber() {
    // Given
    int[] param = {2, 2, 1};

    // When
    int ans = new SingleNumber().singleNumber(param);

    // Then
    assertEquals(1, ans);
  }
}

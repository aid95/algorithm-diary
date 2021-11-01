package javaps.programmers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseNGameTest {

  @DisplayName("Testcase #1")
  @Test
  void solution() {
    // Given
    int n = 2;
    int t = 4;
    int m = 2;
    int p = 1;

    // When
    String result = new BaseNGame().solution(n, t, m, p);

    // Then
    assertEquals("0111", result);
  }

  @DisplayName("Testcase #2")
  @Test
  void solution2() {
    // Given
    int n = 16;
    int t = 16;
    int m = 2;
    int p = 1;

    // When
    String result = new BaseNGame().solution(n, t, m, p);

    // Then
    assertEquals("02468ACE11111111", result);
  }
}

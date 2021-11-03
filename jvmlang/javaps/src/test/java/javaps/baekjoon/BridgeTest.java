package javaps.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BridgeTest {

  @Test
  void dp() {
    // Given
    int n = 2;
    int r = 2;

    // When
    int result = Bridge.dp(n, r);

    // Then
    assertEquals(1, result);
  }

  @Test
  void dp2() {
    // Given
    int n = 29;
    int r = 13;

    // When
    int result = Bridge.dp(n, r);

    // Then
    assertEquals(67863915, result);
  }
}

package javaps.goorm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WinnerTest {

  @Test
  void solution() {
    // Given
    String history = "213412";

    // When
    boolean result = Winner.solution(history);

    // Then
    Assertions.assertTrue(result);
  }

  @Test
  void solution2() {
    // Given
    String history = "21212";

    // When
    boolean result = Winner.solution(history);

    // Then
    Assertions.assertTrue(result);
  }
}

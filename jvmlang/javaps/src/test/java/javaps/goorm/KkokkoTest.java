package javaps.goorm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KkokkoTest {

  @DisplayName("Testcase #1")
  @Test
  void solution() {
    // Given
    String message = "HellO, World!";

    // When
    String result = Kkokko.solution(message);

    // Then
    Assertions.assertEquals("eOo", result);
  }
}

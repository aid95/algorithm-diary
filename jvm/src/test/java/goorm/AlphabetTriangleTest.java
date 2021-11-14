package goorm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlphabetTriangleTest {

  @Test
  void solution() {
    // Given
    String param = "ABCDEFGHIJKLMNO";

    // When
    int result = AlphabetTriangle.solution(param);

    // Then
    Assertions.assertEquals(35, result);
  }
}

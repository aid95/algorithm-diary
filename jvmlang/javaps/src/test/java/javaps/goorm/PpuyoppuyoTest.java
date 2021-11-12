package javaps.goorm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PpuyoppuyoTest {

  @Test
  void solution() {
    // Given
    String s = "ABCCCBBAAA";

    // When
    String result = Ppuyoppuyo.solution(s, 3);

    // Then
    Assertions.assertEquals("", result);
  }

  @Test
  void solutio2() {
    // Given
    String s = "AB";

    // When
    String result = Ppuyoppuyo.solution(s, 1);

    // Then
    Assertions.assertEquals("", result);
  }

  @Test
  void solutio3() {
    // Given
    String s = "ABCCBCCDA";

    // When
    String result = Ppuyoppuyo.solution(s, 2);

    // Then
    Assertions.assertEquals("ADA", result);
  }

  @Test
  void solutio4() {
    // Given
    String s = "ABEBADEEBDCDABABECCAEDACBBABDC";

    // When
    String result = Ppuyoppuyo.solution(s, 2);

    // Then
    Assertions.assertEquals("ABEBADBDCDABABEAEDACABDC", result);
  }

  @Test
  void solutio5() {
    // Given
    String s = "ABAAACBCCA";

    // When
    String result = Ppuyoppuyo.solution(s, 2);

    // Then
    Assertions.assertEquals("ABCBA", result);
  }
}

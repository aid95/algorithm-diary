package javaps.baekjoon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RadioTest {

  @Test
  void solution() {
    // Given
    int a = 100;
    int b = 15;
    List<Integer> favoite = List.of(15);

    // When
    int result = Radio.solution(a, b, favoite);

    // Then
    Assertions.assertEquals(1, result);
  }
}

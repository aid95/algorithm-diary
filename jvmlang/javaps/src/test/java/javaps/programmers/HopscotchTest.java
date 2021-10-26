package javaps.programmers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HopscotchTest {

  @DisplayName("testcase #1")
  @Test
  public void testSolution() {
    // Given
    int[][] param = new int[][] {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};

    // When
    int ret = new Hopscotch().solution(param);

    // Then
    assertEquals(16, ret);
  }

  @DisplayName("testcase #2")
  @Test
  public void testSolution2() {
    // Given
    int[][] param = new int[][] {{0, 1, 2, 3}, {0, 0, 0, 100}};

    // When
    int ret = new Hopscotch().solution(param);

    // Then
    assertEquals(102, ret);
  }
}

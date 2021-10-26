package javaps.programmers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeagueTableTest {

  @DisplayName("testcase #1")
  @Test
  public void test_1() {
    // given
    int N = 8;
    int A = 4;
    int B = 7;

    // when
    int answer = new LeagueTable().solution(8, 4, 8);

    // then
    assertEquals(3, answer);
  }
}

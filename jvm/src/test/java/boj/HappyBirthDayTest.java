package boj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HappyBirthDayTest {

  @Test
  void testStringToStudent() {
    // Given
    String info = "Mickey 1 10 1991";

    // When
    HappyBirthDay.Student mickey = new HappyBirthDay.Student(info);

    // Then
    Assertions.assertEquals("Mickey", mickey.getName());
  }
}

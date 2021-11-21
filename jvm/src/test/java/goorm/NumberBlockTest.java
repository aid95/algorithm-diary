package goorm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class NumberBlockTest {

  @Test
  void solution() {
    // Given
    List<NumberBlock.Command> commands = new ArrayList<>();
    commands.add(new NumberBlock.AddCommand(1));
    commands.add(new NumberBlock.RemoveCommand());
    commands.add(new NumberBlock.AddCommand(2));
    commands.add(new NumberBlock.AddCommand(3));
    commands.add(new NumberBlock.RemoveCommand());
    commands.add(new NumberBlock.RemoveCommand());

    // When
    int result = NumberBlock.solution(commands);

    // Then
    Assertions.assertEquals(1, result);
  }

  @Test
  void solution2() {
    // Given
    List<NumberBlock.Command> commands = new ArrayList<>();
    commands.add(new NumberBlock.AddCommand(3));
    commands.add(new NumberBlock.AddCommand(2));
    commands.add(new NumberBlock.AddCommand(1));
    commands.add(new NumberBlock.RemoveCommand());
    commands.add(new NumberBlock.AddCommand(4));
    commands.add(new NumberBlock.RemoveCommand());
    commands.add(new NumberBlock.RemoveCommand());
    commands.add(new NumberBlock.RemoveCommand());
    commands.add(new NumberBlock.AddCommand(6));
    commands.add(new NumberBlock.AddCommand(7));
    commands.add(new NumberBlock.AddCommand(8));
    commands.add(new NumberBlock.RemoveCommand());
    commands.add(new NumberBlock.RemoveCommand());
    commands.add(new NumberBlock.RemoveCommand());

    // When
    int result = NumberBlock.solution(commands);

    // Then
    Assertions.assertEquals(2, result);
  }

  @Test
  void solution3() {
    // Given
    List<NumberBlock.Command> commands = new ArrayList<>();
    commands.add(new NumberBlock.AddCommand(3));
    commands.add(new NumberBlock.AddCommand(2));
    commands.add(new NumberBlock.AddCommand(1));
    commands.add(new NumberBlock.RemoveCommand());
    commands.add(new NumberBlock.RemoveCommand());
    commands.add(new NumberBlock.RemoveCommand());

    // When
    int result = NumberBlock.solution(commands);

    // Then
    Assertions.assertEquals(0, result);
  }
}

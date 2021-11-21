package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberBlock {

  static int nextId = 1;
  static int sortedCount = 0;

  public static void init(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    br.readLine();

    String s = null;
    List<Command> commands = new ArrayList<>();
    while ((s = br.readLine()) != null) {
      if (s.startsWith("add")) {
        commands.add(new AddCommand(Integer.parseInt(s.split(" ")[1])));
      } else {
        commands.add(new RemoveCommand());
      }
    }
    System.out.println(solution(commands));
  }

  public static int solution(List<Command> commands) {
    commands.forEach(Command::execute);
    return sortedCount;
  }

  public abstract static class Command {

    static Stack<Integer> stack = new Stack<>();

    abstract void execute();
  }

  public static class AddCommand extends Command {

    int id;

    public AddCommand(int id) {
      this.id = id;
    }

    @Override
    void execute() {
      stack.push(id);
    }
  }

  public static class RemoveCommand extends Command {

    @Override
    void execute() {
      if (!stack.isEmpty() && stack.peek() != nextId) {
        sortedCount++;
        stack.clear();
      }
      if (!stack.isEmpty()) {
        stack.pop();
      }
      nextId++;
    }
  }
}

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HappyBirthDay {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine().trim());

    List<Student> students = new ArrayList<>();
    for (int i = 0; i < tc; i++) {
      students.add(br.readLine().trim().transform(Student::new));
    }

    students.sort(
        Comparator.comparing(Student::getYear)
            .thenComparing(Student::getMonth)
            .thenComparing(Student::getDay));

    System.out.println(students.get(students.size() - 1));
    System.out.println(students.get(0));
  }

  public static class Student {
    private String name;
    private int day;
    private int year;
    private int month;

    public Student(String info) {
      parseInfo(info);
    }

    private void parseInfo(String info) {
      String[] e = info.split(" ");
      this.name = e[0];
      this.day = Integer.parseInt(e[1]);
      this.month = Integer.parseInt(e[2]);
      this.year = Integer.parseInt(e[3]);
    }

    public String getName() {
      return name;
    }

    public int getDay() {
      return day;
    }

    public int getYear() {
      return year;
    }

    public int getMonth() {
      return month;
    }

    @Override
    public String toString() {
      return getName();
    }
  }
}

package test.coding.algorithm.programmers;

import test.coding.algorithm.Solution;

public class SkillTree implements Solution {

  @Override
  public void solve() {
    int answer = solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"});
    System.out.println(answer);
  }

  public int solution(String skill, String[] skill_trees) {
    int answer = 0;
    for (String skillTree : skill_trees) {
      answer += checkSkillTree(skill, skillTree) ? 1 : 0;
    }
    return answer;
  }

  public boolean checkSkillTree(String skillSeq, String skillTree) {
    int lastMatchSkillIdx = 0;
    for (char skillId : skillTree.toCharArray()) {
      int idx = skillSeq.indexOf(skillId);
      if (idx == -1) {
        continue;
      }
      if (lastMatchSkillIdx != idx) {
        return false;
      } else {
        lastMatchSkillIdx += 1;
      }
    }
    return true;
  }
}

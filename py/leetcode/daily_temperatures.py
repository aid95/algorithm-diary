from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        answer = [0] * len(temperatures)
        stack = []
        for idx, temp in enumerate(temperatures):
            while stack and temp > temperatures[stack[-1]]:
                prev_idx = stack.pop()
                answer[prev_idx] = idx - prev_idx
            stack.append(idx)
        return answer


if __name__ == '__main__':
    result = Solution().dailyTemperatures(temperatures=[73, 74, 75, 71, 69, 72, 76, 73])
    print(result)

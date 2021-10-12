class Solution:
    def isValid(self, s: str) -> bool:
        table = {
            ')': '(',
            ']': '[',
            '}': '{',
        }

        stack = []
        for ch in s:
            if ch not in table:
                stack.append(ch)
            else:
                if not stack or stack.pop() != table[ch]:
                    return False
        return len(stack) == 0


if __name__ == '__main__':
    result = Solution().isValid(s='()[]{')
    print(result)

import collections
import re
import sys
from typing import List, Optional

from leetcode.list_node import ListNode


class Solution:

    def trap(self, height: List[int]) -> int:
        answer = 0
        left, right = 0, len(height) - 1
        max_l, max_r = height[left], height[right]
        while left < right:
            max_l, max_r = max(max_l, height[left]), max(max_r, height[right])
            if max_l <= max_r:
                answer += max_l - height[left]
                left += 1
            else:
                answer += max_r - height[right]
                right -= 1
        return answer

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        answer = []
        nums.sort()
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            left, right = i + 1, len(nums) - 1
            while left < right:
                s = nums[i] + nums[left] + nums[right]
                if s < 0:
                    left += 1
                elif s > 0:
                    right -= 1
                else:
                    answer.append([nums[i], nums[left], nums[right]])
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1
        return answer

    def arrayPairSum(self, nums: List[int]) -> int:
        return sum(sorted(nums)[::2])

    def productExceptSelf(self, nums: List[int]) -> List[int]:
        dp = []
        p = 1
        for i in range(0, len(nums)):
            dp.append(p)
            p = p * nums[i]
        p = 1
        for i in range(len(nums) - 1, -1, -1):
            dp[i] = dp[i] * p
            p = p * nums[i]
        return dp

    def maxProfit(self, prices: List[int]) -> int:
        p = 0
        min_p = sys.maxsize
        for price in prices:
            min_p = min(min_p, price)
            p = max(p, price - min_p)
        return p

    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        s = re.sub(r'[^a-z0-9]', '', s)
        return s == s[::-1]

    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letters = []
        digits = []
        for log in logs:
            if log.split()[1].isdigit():
                digits.append(log)
            else:
                letters.append(log)
        letters.sort(key=lambda x: (x.split()[1:], x.split()[0]))
        print(letters)
        return letters + digits

    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        words = [word for word in re.sub(r'[^\w]', ' ', paragraph).lower().split() if word not in banned]
        counter = collections.Counter(words)
        return counter.most_common(1)[0][0]

    def reverseString(self, s: List[str]) -> None:
        l, r = 0, len(s) - 1
        while l < r:
            s[l], s[r] = s[r], s[l]
            l = l + 1
            r = r - 1
        return

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = collections.defaultdict(list)
        for word in strs:
            groups[''.join(sorted(word))].append(word)
        return list(groups.values())

    def longestPalindrome(self, s: str) -> str:

        def expand(left: int, right: int) -> str:
            while 0 <= left and right < len(s) and s[left] == s[right]:
                left = left - 1
                right = right + 1
            return s[left + 1:right]

        if len(s) < 2 or s == s[::-1]:
            return s

        answer = ''
        for i in range(len(s) - 1):
            answer = max(answer, expand(i, i + 1), expand(i, i + 2), key=len)
        return answer

    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:

        def reverse(node: ListNode, prev_node: ListNode):
            if not node:
                return prev_node
            next_node, node.next = node.next, prev_node
            return reverse(next_node, node)

        return reverse(head, None)

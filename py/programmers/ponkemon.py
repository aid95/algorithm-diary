def solution(nums: [int]) -> int:
    answer = len(set(nums))
    cnt = len(nums) // 2
    return min(answer, cnt)


if __name__ == '__main__':
    result = solution(nums=[3, 1, 2, 3])
    print(result)

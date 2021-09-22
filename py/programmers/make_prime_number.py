def is_prime(n):
    if n == 1:
        return False

    i = 2
    while i * i <= n:
        if n % i == 0:
            return False
        i += 1
    return True


def solution(nums: [int]) -> int:
    answer = 0
    for i in range(0, len(nums)):
        for j in range(i + 1, len(nums)):
            for k in range(j + 1, len(nums)):
                acc = nums[i] + nums[j] + nums[k]
                answer += 1 if is_prime(acc) else 0
    return answer


if __name__ == '__main__':
    result = solution(nums=[1, 2, 7, 6, 4])
    print(result)

def solution(d: [int], budget: int) -> int:
    d.sort()
    while sum(d) >= budget:
        d.pop()
    return len(d)


if __name__ == '__main__':
    result = solution(d=[1, 3, 2, 5, 4], budget=9)
    print(result)

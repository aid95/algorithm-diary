def solution(numbers: [int]) -> [int]:
    answer = []
    for i in range(0, len(numbers)):
        for j in range(i + 1, len(numbers)):
            answer.append(numbers[i] + numbers[j])

    return sorted(set(answer))


if __name__ == '__main__':
    result = solution(numbers=[2, 1, 3, 4, 1])
    print(result)

def solution(salaries: list[int]) -> int:
    return sorted(salaries)[1]


if __name__ == '__main__':
    user_input = input()
    param = [int(x) for x in user_input.split()]
    print(solution(salaries=param))

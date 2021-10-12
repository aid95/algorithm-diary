import math


def solution(w: int, h: int) -> int:
    total_square = w * h
    answer = total_square - (w + h - math.gcd(w, h))
    return answer


if __name__ == '__main__':
    result = solution(w=8, h=12)
    print(result)

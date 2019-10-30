import sys


def solution(s: str) -> int:
    answer = sys.maxsize

    for w in range(1, (len(s) // 2) + 1):
        sub = s[:w]
        count = 1
        new_s = ''
        for pad in range(w, len(s), w):
            if sub == s[pad:pad + w]:
                count += 1
            else:
                if count > 1:
                    new_s += '{}{}'.format(count, sub)
                else:
                    new_s += sub
                sub = s[pad:pad + w]
                count = 1
        if count > 1:
            new_s += '{}{}'.format(count, sub)
        else:
            new_s += sub
        answer = min(answer, len(new_s))

    return answer


if __name__ == '__main__':
    tc = 'ababcdcdababcdcd'
    result = solution(tc)
    print(result)

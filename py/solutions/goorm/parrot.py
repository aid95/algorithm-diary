import sys

rl = sys.stdin.readline


def solution(grammars: list[str]) -> list[str]:
    result = []
    c = ['a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U']
    for grammar in grammars:
        a = ''
        for ch in grammar:
            if ch in c:
                a += ch
        result.append(a if len(a) > 0 else '???')
    return result


if __name__ == '__main__':
    n = int(rl().rstrip())
    grammars = []
    for _ in range(n):
        grammars.append(rl().rstrip())
    print('\n'.join(x for x in solution(grammars)))

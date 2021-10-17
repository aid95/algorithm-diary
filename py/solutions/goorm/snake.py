import sys

rl = sys.stdin.readline


def solution(height: int, width: int) -> list[list[bool]]:
    mp = [[False] * width for _ in range(height)]

    s, e, c, t = 0, width, 1, width - 1
    _s, _e, _c, _t = width - 1, -1, -1, 0
    for y in range(0, height, 2):
        for x in range(s, e, c):
            mp[y][x] = True
        if (y + 1) < height:
            mp[y + 1][t] = True
        (s, e, c, t), (_s, _e, _c, _t) = (_s, _e, _c, _t), (s, e, c, t)

    return mp


if __name__ == '__main__':
    n, m = [int(x) for x in rl().split()]
    answer = solution(n, m)

    for i in range(n):
        for j in range(m):
            if answer[i][j]:
                print("#", end='')
            else:
                print(".", end='')
        print()

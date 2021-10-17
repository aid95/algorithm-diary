import sys

rl = sys.stdin.readline


def custom_round(target: float) -> int:
    return int(target) + 1 if (target - int(target)) >= 0.5 else int(target)


def solution(jw: int, sw: int, day: int) -> (int, int):
    p, _p = -1, 1
    turn = True
    for _ in range(day):
        money = jw if turn else sw
        turn = not turn

        dis = custom_round(money / 2) if money > 1 else 1
        jw += dis * p
        sw += dis * _p
        p, _p = _p, p
    return jw, sw


if __name__ == '__main__':
    m, n = [int(x) for x in rl().rstrip().split()]
    d = int(rl().rstrip())
    ans = solution(m, n, d)
    print(f'{ans[0]} {ans[1]}')

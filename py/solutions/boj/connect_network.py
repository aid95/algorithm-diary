import heapq
import sys

rl = sys.stdin.readline

root = []


def find(x: int) -> int:
    if root[x] == x:
        return x
    root[x] = find(root[x])
    return root[x]


def union(x: int, y: int) -> None:
    _x = find(x)
    _y = find(y)
    if _x != _y:
        root[_x] = _y
    return


def solution(n: int, g: [(int, int, int)]) -> int:
    global root

    for i in range(n + 1):
        root.append(i)

    pq = []
    for (s, d, c) in g:
        heapq.heappush(pq, (c, (s, d)))

    ret = 0
    while pq:
        c, (s, d) = heapq.heappop(pq)

        if find(s) == find(d):
            continue

        ret += c
        union(s, d)

    return ret


if __name__ == '__main__':
    N = int(rl().rstrip())
    M = int(rl().rstrip())
    G = []
    for _ in range(M):
        src, des, cost = map(int, rl().rstrip().split())
        G.append((src, des, cost))

    ans = solution(N, G)
    print(ans)

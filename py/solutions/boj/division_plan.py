import heapq
import sys

rl = sys.stdin.readline

root = []
rank = []


def find(x: int) -> int:
    if x == root[x]:
        return x
    root[x] = find(root[x])
    return root[x]


def union(x: int, y: int):
    _x = find(x)
    _y = find(y)
    if _x != _y:
        if rank[_x] > rank[_y]:
            _x, _y = _y, _x
        root[_x] = _y
        if rank[_x] == rank[_y]:
            rank[_y] += 1
    return


def solution(m: int, n: int, graph: list[(int, int, int)]) -> int:
    answer = []
    for i in range(m + 1):
        root.append(i)
        rank.append(1)
    q = []
    for (src, des, cost) in graph:
        heapq.heappush(q, (cost, (src, des)))

    cnt = 0
    while q and cnt < n - 2:
        cost, (src, des) = heapq.heappop(q)
        if find(src) != find(des):
            answer.append(cost)
            union(src, des)
            cnt += 1
    return sum(answer[:-1])


if __name__ == '__main__':
    M, N = [int(x) for x in rl().rstrip().split()]
    GRAPH = []
    for _ in range(N):
        A, B, C = [int(x) for x in rl().rstrip().split()]
        GRAPH.append((A, B, C))
    print(solution(M, N, GRAPH))

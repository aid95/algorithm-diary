import heapq
import sys

rl = sys.stdin.readline

root = []
rank = []


def find(x: int) -> int:
    if x != root[x]:
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


def solution(graph: list[(int, int, int)]):
    answer = []
    q = []
    for (src, des, cost) in graph:
        heapq.heappush(q, (cost, (src, des)))
    while q:
        cost, (src, des) = heapq.heappop(q)
        if find(src) != find(des):
            answer.append(cost)
            union(src, des)
    return sum(answer[:-1])


if __name__ == '__main__':
    M, N = [int(x) for x in rl().rstrip().split()]
    for i in range(M + 1):
        root.append(i)
        rank.append(1)
    GRAPH = []
    for _ in range(N):
        A, B, C = [int(x) for x in rl().rstrip().split()]
        GRAPH.append((A, B, C))
    print(solution(GRAPH))

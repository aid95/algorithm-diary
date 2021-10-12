import collections
import heapq
import sys
from typing import Any

rl = sys.stdin.readline

graph = collections.defaultdict(list)


def dijkstra(x: int) -> collections.defaultdict[Any, int]:
    dist = collections.defaultdict(int)
    q = [(0, x)]
    while q:
        cost, node = heapq.heappop(q)
        if node not in dist:
            dist[node] = cost
            for (c, n) in graph[node]:
                heapq.heappush(q, (c + cost, n))
    return dist


def solution(n: int, x: int) -> int:
    x2n = dijkstra(x)
    n2x = []
    for i in range(1, n + 1):
        n2x.append((i, dijkstra(i)))

    dist = []
    for i, d in n2x:
        dist.append((i, d[x] + x2n[i]))
    dist.sort(key=lambda k: k[1])
    return dist[-1][1]


if __name__ == '__main__':
    N, M, X = map(int, rl().rstrip().split())
    for _ in range(M):
        S, D, C = map(int, rl().rstrip().split())
        graph[S].append((C, D))
    print(solution(N, X))

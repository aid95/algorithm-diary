import collections
import heapq
import sys

rl = sys.stdin.readline
graph = []
parents = collections.defaultdict(int)
rank = collections.defaultdict(int)


def find(x: int):
    if x != parents[x]:
        parents[x] = find(parents[x])
    return parents[x]


def union(s: int, d: int):
    p_s = find(s)
    p_d = find(d)
    if p_s != p_d:
        if p_s > p_d:
            parents[p_s] = p_d
        else:
            parents[p_d] = p_s


def solution():
    answer = 0
    while graph:
        w, (u, v) = heapq.heappop(graph)
        if find(u) == find(v):
            continue
        answer += w
        union(u, v)
    return answer


if __name__ == '__main__':
    V, E = [int(x) for x in rl().rstrip().split()]

    for i in range(1, V + 1):
        rank[i] = 1
        parents[i] = i

    for _ in range(E):
        U, _V, W = [int(x) for x in rl().rstrip().split()]
        heapq.heappush(graph, (W, (U, _V)))

    print(solution())

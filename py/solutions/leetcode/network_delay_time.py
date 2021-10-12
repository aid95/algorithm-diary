import collections
import heapq


def network_delay_time(times: list[list[int]], n: int, k: int) -> int:
    graph = collections.defaultdict(list)
    for u, v, w in times:
        graph[u].append((v, w))

    q = [(0, k)]
    dist = collections.defaultdict(int)
    while q:
        cost, node = heapq.heappop(q)
        if node not in dist:
            dist[node] = cost
            for v, w in graph[node]:
                heapq.heappush(q, (w + cost, v))

    if len(dist) == n:
        return max(dist.values())
    return -1


if __name__ == '__main__':
    result = network_delay_time(times=[[2, 1, 1], [2, 3, 1], [3, 4, 1]], n=4, k=2)
    print(result)

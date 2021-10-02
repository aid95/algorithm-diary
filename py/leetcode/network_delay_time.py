import collections
import heapq


class Solution:
    def networkDelayTime(self, times: list[list[int]], n: int, k: int) -> int:
        graph = collections.defaultdict(list)
        for u, v, w in times:
            graph[u].append((v, w))

        Q = [(0, k)]
        dist = collections.defaultdict(int)
        while Q:
            cost, node = heapq.heappop(Q)
            if node not in dist:
                dist[node] = cost
                for v, w in graph[node]:
                    heapq.heappush(Q, (w + cost, v))

        if len(dist) == n:
            return max(dist.values())
        return -1


if __name__ == '__main__':
    result = Solution().networkDelayTime(times=[[2, 1, 1], [2, 3, 1], [3, 4, 1]], n=4, k=2)
    print(result)

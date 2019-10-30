import heapq
import sys


def solution(n: int, road: [[int]], k: int) -> int:
    answer = 0

    g = [[] for _ in range(k + 1)]
    distance = [sys.maxsize] * (k + 1)

    for a, b, c in road:
        g[a].append((b, c))
        g[b].append((a, c))

    def dijkstra(start: int):
        q = []
        heapq.heappush(q, (start, 0))

        while q:
            cur, cost = heapq.heappop(q)
            if distance[cur] < cost:
                continue
            for linked_node, node_cost in g[cur]:
                acc_cost = node_cost + cost
                if distance[linked_node] > acc_cost:
                    distance[linked_node] = acc_cost
                    heapq.heappush(q, (linked_node, acc_cost))

    return answer


if __name__ == '__main__':
    result = solution(n=5, road=[[1, 2, 1], [2, 3, 3], [5, 2, 2], [1, 4, 2], [5, 3, 1], [5, 4, 2]], k=3)
    print(result)

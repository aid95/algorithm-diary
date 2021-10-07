import collections
import heapq
import sys

rl = sys.stdin.readline
MAX = 100_001


def solution(n: int, k: int) -> int:
    dist = collections.defaultdict(int)
    q = [(0, n)]
    while q:
        sec, loc = heapq.heappop(q)
        if loc == k:
            return sec
        if loc not in dist:
            dist[loc] = sec
            if loc * 2 < MAX:
                heapq.heappush(q, (sec, loc * 2))
            if loc - 1 >= 0:
                heapq.heappush(q, (sec + 1, loc - 1))
            if loc + 1 < MAX:
                heapq.heappush(q, (sec + 1, loc + 1))


if __name__ == '__main__':
    n, k = [int(x) for x in rl().rstrip().split()]
    print(solution(n, k))

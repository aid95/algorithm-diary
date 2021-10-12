import heapq


def solution(scoville: [int], K: int) -> int:
    heapq.heapify(scoville)

    answer = 0
    while scoville[0] < K:
        heapq.heappush(scoville, heapq.heappop(scoville) + 2 * heapq.heappop(scoville))
        answer += 1
        if len(scoville) == 1 and scoville[0] < K:
            return -1
    return answer


if __name__ == '__main__':
    result = solution(scoville=[1, 2, 3, 9, 10, 12], K=7)
    print(result)

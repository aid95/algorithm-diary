import sys
from collections import deque


def check_manhattan(place: [str]) -> bool:
    d_x = [-1, 1, 0, 0]
    d_y = [0, 0, -1, 1]

    pos = []
    for y in range(5):
        for x in range(5):
            if place[y][x] == 'P':
                pos.append((x, y))

    for start in pos:
        q = deque([start])
        visited = [[False] * 5 for _ in range(5)]
        distance = [[0] * 5 for _ in range(5)]

        visited[start[1]][start[0]] = True
        while q:
            x, y = q.popleft()
            for i in range(4):
                nx = x + d_x[i]
                ny = y + d_y[i]
                if 0 <= nx < 5 and 0 <= ny < 5 and not visited[ny][nx]:
                    if place[ny][nx] == 'O':
                        q.append((nx, ny))
                        visited[ny][nx] = True
                        distance[ny][nx] = distance[y][x] + 1
                    elif place[ny][nx] == 'P' and distance[y][x] <= 1:
                        return False
    return True


def solution(places: [[str]]) -> [int]:
    answer = []
    for place in places:
        answer.append(1 if check_manhattan(place) else 0)
    return answer


if __name__ == '__main__':
    sys.setrecursionlimit(100005)
    result = solution(places=[["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"],
                              ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
                              ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"],
                              ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
                              ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]])
    print(result)

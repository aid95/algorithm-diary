#!/usr/bin/python3
# -*- coding: cp949 -*-

import collections


def solution(n: int, computers: [[int]]) -> int:
    answer = 0
    visited = [False] * n
    dq = collections.deque()
    for c in range(n):
        if not visited[c]:
            visited[c] = True
            dq.append(c)
            answer += 1
        while dq:
            p = dq.popleft()
            for o in range(n):
                if o != p and computers[p][o] and not visited[o]:
                    visited[o] = True
                    dq.append(o)
    return answer

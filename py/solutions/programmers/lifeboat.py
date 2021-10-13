#!/usr/bin/python3
# -*- coding: cp949 -*-

def solution(people: [int], limit: int) -> int:
    answer = 0
    people = sorted(people, reverse=True)
    s, e = 0, len(people) - 1
    while s <= e:
        if people[s] + people[e] <= limit:
            e -= 1
        s += 1
        answer += 1
    return answer


'''2차 시도 (정확성: 20.0 / 효율성: 10.0)
def solution(people: [int], limit: int) -> int:
    people.sort()

    hf = (limit / 2) + 1
    pv = bisect_right(people, hf)
    d, m = divmod(len(people[:pv]), 2)

    answer = len(people[pv:])
    answer += d + m
    return answer
'''

'''1차 시도 (정확성: 20.0 / 효율성: 0.0)
def solution(people: [int], limit: int) -> int:
    people.sort()
    answer = 0
    while people:
        cur = 0
        cnt = 0
        while cnt < 2 and people and limit >= (cur + people[0]):
            cur += people.pop(0)
            cnt += 1
        answer += 1
    return answer
'''

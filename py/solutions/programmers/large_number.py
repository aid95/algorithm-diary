#!/usr/bin/python3
# -*- coding: cp949 -*-

def solution(number: str, k: int) -> str:
    number = [int(c) for c in number]
    answer = []

    for n in number:
        while 0 < k and answer and answer[-1] < n:
            k -= 1
            answer.pop()
        answer.append(n)

    answer = answer[:len(answer) - k]
    return ''.join([str(x) for x in answer])


''' 1차 시도
answer = '0'


def solution(number: str, k: int):
    global answer

    number = [c for c in number]
    bk(number, 0, '', len(number) - k)
    return f'{answer}'


def bk(nums: [str], p: int, s: str, k: int):
    global answer

    if k == len(s):
        sn = int(s)
        an = int(answer)
        answer = answer if sn < an else sn
        return

    for i in range(p, len(nums)):
        bk(nums, i + 1, s + nums[i], k)
'''
